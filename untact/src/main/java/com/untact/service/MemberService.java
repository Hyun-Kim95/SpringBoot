package com.untact.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untact.dao.MemberDao;
import com.untact.dto.Member;
import com.untact.dto.ResultData;
import com.untact.util.Util;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public ResultData join(Map<String, Object> param) {
		memberDao.join(param);

		int id = Util.getAsInt(param.get("id"), 0);
		return new ResultData("S-1", String.format("%s님 환영합니다.", param.get("nickname")), "id", id);
	}

	public Member getMember(int id) {
		return memberDao.getMember(id);
	}
	
	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public ResultData modifyMember(Map<String, Object> param) {
		memberDao.modifyMember(param);
		
		return new ResultData("S-1", "회원정보가 수정되었습니다.");
	}

	public boolean isAdmin(int actorId) {
		return actorId == 1;
	}

	public boolean isAdmin(Member actor) {
		return isAdmin(actor.getId());
	}

	public Member getMemberByAuthKey(String authKey) {
		return memberDao.getMemberByAuthKey(authKey);
	}
}
