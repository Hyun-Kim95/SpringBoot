package com.untact.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untact.dao.ArticleDao;
import com.untact.dto.Article;
import com.untact.dto.Board;
import com.untact.dto.ResultData;
import com.untact.util.Util;

@Service
public class ArticleService {
	@Autowired
	private GenFileService genFileService;
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private MemberService memberService;

	public Article getArticle(int id) {
		return articleDao.getArticle(id);
	}
	
	public List<Article> getArticles(String searchKeywordType, String searchKeyword) {
		return articleDao.getArticles(searchKeywordType, searchKeyword);
	}

	public ResultData addArticle(Map<String, Object> param) {
		articleDao.addArticle(param);
		
		int id = Util.getAsInt(param.get("id"),0);
		
		String genFileIdsStr = Util.ifEmpty((String)param.get("genFileIdsStr"), null);
		
		if(genFileIdsStr != null) {
			// ex) "10,20,30" => [10, 20, 30]
			List<Integer> genFileIds = Util.getListDividedBy(genFileIdsStr, ",");
			
			// 파일이 먼저 생성된 후에, 관련 데이터가 생성되는 경우에는, file의 relId가 일단 0으로 저장된다.
			// 그것을 뒤늦게라도 이렇게 고쳐야 함
			for(int genFileId : genFileIds) {
				genFileService.changeRelId(genFileId, id);
			}
		}
				
		return new ResultData("S-1","성공하였습니다.", "id",id);
	}

	public ResultData deleteArticle(int id) {
		articleDao.deleteArticle(id);
		
		genFileService.deleteFiles("article", id);
		
		return new ResultData("S-1","해당 게시물을 제거하였습니다.","id",id);		 
	}

	public ResultData modifyArticle(int id, String title, String body) {
		articleDao.modifyArticle(id,title,body);
						
		return new ResultData("S-1", String.format("%d번 게시물이 수정되었습니다.", id), "id", id);
	}

	public ResultData getActorCanModifyRd(Article article, int actorId) {
		if(article.getMemberId() == actorId) {
			return new ResultData("S-1","가능합니다.");
		}
		
		if(memberService.isAdmin(actorId)) {
			return new ResultData("S-2","가능합니다.");
		}
		
		return new ResultData("F-1","권한이 없습니다.");
	}

	public ResultData getActorCanDeleteRd(Article article, int actorId) {
		return getActorCanModifyRd(article, actorId);
	}

	public Article getForPrintArticle(int id) {
		return articleDao.getForPrintArticle(id);
	}

	public List<Article> getForPrintArticles(String searchKeywordType, String searchKeyword, int boardId, int page,
			int itemsInAPage) {
		
		int limitStart = (page - 1)*itemsInAPage;
		int limitTake = itemsInAPage;
		return articleDao.getForPrintArticles(searchKeywordType, searchKeyword, boardId, limitStart, limitTake);
	}

	public Board getBoard(int boardId) {
		return articleDao.getBoard(boardId);
	}

	public ResultData addReply(Map<String, Object> param) {
		articleDao.addReply(param);
		
		int id = Util.getAsInt(param.get("id"),0);
		return new ResultData("S-1","성공하였습니다.", "id",id);
	}
}