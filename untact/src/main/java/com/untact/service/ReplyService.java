package com.untact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untact.dao.ReplyDao;
import com.untact.dto.Reply;
import com.untact.dto.ResultData;

@Service
public class ReplyService {
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private MemberService memberService;

	public List<Reply> getForPrintReplies(String relTypeCode, Integer relId) {
		return replyDao.getForPrintReplies(relTypeCode, relId);
	}

	public Reply getReply(int id) {
		return replyDao.getReply(id);
	}

	public ResultData getActorCanDeleteRd(Reply reply, int actorId) {
		if(reply.getMemberId() == actorId) {
			return new ResultData("S-1","가능합니다.");
		}
		
		if(memberService.isAdmin(actorId)) {
			return new ResultData("S-2","가능합니다.");
		}
		
		return new ResultData("F-1","권한이 없습니다.");
	}

	public ResultData deleteReply(int id) {
		replyDao.deleteReply(id);
		
		return new ResultData("S-1","해당 댓글을 제거하였습니다.","id",id);	
	}

	public ResultData getActorCanModifyRd(Reply reply, int actorId) {
		return getActorCanDeleteRd(reply,actorId);
	}

	public ResultData modifyReply(int id, String body) {
		replyDao.modifyReply(id,body);
		
		return new ResultData("S-1", String.format("%d번 댓글이 수정되었습니다.", id), "id", id);
	}

}
