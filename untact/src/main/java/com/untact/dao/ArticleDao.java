package com.untact.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.untact.dto.Article;
import com.untact.dto.Board;

@Mapper
public interface ArticleDao {

	Article getArticle(@Param("id")int id);

	void addArticle(Map<String, Object> param);
	
	void deleteArticle(@Param("id")int id);
	
	void modifyArticle(@Param("id")int id,@Param("title") String title,@Param("body") String body);
	
	List<Article> getArticles(@Param("searchKeywordType")String searchKeywordType,
			@Param("searchKeyword") String searchKeyword);
	
	Article getForPrintArticle(@Param("id")int id);
	
	List<Article> getForPrintArticles(@Param("searchKeywordType")String searchKeywordType,
			@Param("searchKeyword") String searchKeyword, @Param("boardId") int boardId,
			@Param("limitStart") int limitStart,
			@Param("limitTake")int limitTake);

	Board getBoard(@Param("boardId")int boardId);

	void addReply(Map<String, Object> param);
	
}
