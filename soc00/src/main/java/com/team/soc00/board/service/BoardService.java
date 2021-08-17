package com.team.soc00.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.team.soc00.board.vo.ArticleVO;

public interface BoardService {
	
	public List<ArticleVO> osSoccerList() throws DataAccessException;
	
	public int articleCount()throws DataAccessException;
	
	public List osListPage(int displayPost, int postNum)throws DataAccessException;

	public void osWrite2(ArticleVO articleVO)throws DataAccessException;
	
	public ArticleVO osView(int no)throws DataAccessException;
	
	public int osModi(ArticleVO vo)throws DataAccessException;
	
	public int osDelete(int no)throws DataAccessException;
	
	public int s1Count()throws DataAccessException;
	
	public int osViewCount(int no)throws DataAccessException;
	
	//국내축구
	public int krArticleCount()throws DataAccessException;
	
	public List krSoccerList(int displayPost, int postNum)throws DataAccessException;
	
	public void krWrite2(ArticleVO articleVO)throws DataAccessException;
	
	public ArticleVO krView(int no)throws DataAccessException;

	public int krModi(ArticleVO vo)throws DataAccessException;
	
	public int krDelete(int no)throws DataAccessException;
	
	public int krViewCount(int no)throws DataAccessException;
	
	//뉴스
	public int newsArticleCount()throws DataAccessException;
	
	public List newsList(int displayPost, int postNum)throws DataAccessException;
	
	public void newsWrite2(ArticleVO articleVO)throws DataAccessException;
	
	public ArticleVO newsView(int no)throws DataAccessException;

	public int newsModi(ArticleVO vo)throws DataAccessException;
	
	public int newsDelete(int no)throws DataAccessException;
	
	public int newsViewCount(int no)throws DataAccessException;
	
	
	//자유
	public int freeArticleCount()throws DataAccessException;
	
	public List freeList(int displayPost, int postNum)throws DataAccessException;
	
	public void freeWrite2(ArticleVO articleVO)throws DataAccessException;
	
	public ArticleVO freeView(int no)throws DataAccessException;

	public int freeModi(ArticleVO vo)throws DataAccessException;
	
	public int freeDelete(int no)throws DataAccessException;
	
	public int freeViewCount(int no)throws DataAccessException;
	

}
