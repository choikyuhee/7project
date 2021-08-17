package com.team.soc00.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team.soc00.board.dao.BoardDAO;
import com.team.soc00.board.vo.ArticleVO;

@Service("boardService")

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<ArticleVO> osSoccerList() throws DataAccessException {
		List<ArticleVO> osSoccerList = boardDAO.osSoccerList();
		return osSoccerList;
	}
	
	@Override
	public int articleCount()throws DataAccessException {
		return boardDAO.articleCount();
	}
	
	@Override
	public List osListPage(int displayPost, int postNum)throws DataAccessException {
		return boardDAO.osListPage(displayPost, postNum);
	}
	
	@Override
	public void osWrite2(ArticleVO articleVO)throws DataAccessException {
		boardDAO.osWrite2(articleVO);
	}
	
	@Override
	public ArticleVO osView(int no)throws DataAccessException{
		return boardDAO.osView(no);
	}
	
	@Override
	public int osViewCount(int no)throws DataAccessException {
		int result = boardDAO.osViewCount(no);
		return result;
	}
	
	@Override
	public int osModi(ArticleVO vo)throws DataAccessException {
		int result = boardDAO.osModi(vo);
		return result;
	}
	
	@Override
	public int osDelete(int no)throws DataAccessException {
		return boardDAO.osDelete(no);
	}
	
	public int s1Count()throws DataAccessException {
		return boardDAO.s1Count();
	}
	
	//국내축구
	
	@Override
	public int krArticleCount()throws DataAccessException {
		return boardDAO.krArticleCount();
	}
	
	@Override
	public List krSoccerList(int displayPost, int postNum)throws DataAccessException {
		return boardDAO.krSoccerList(displayPost, postNum);
	}
	
	@Override
	public void krWrite2(ArticleVO articleVO)throws DataAccessException {
		boardDAO.krWrite2(articleVO);
	}
	
	@Override
	public ArticleVO krView(int no)throws DataAccessException{
		return boardDAO.krView(no);
	}
	
	@Override
	public int krViewCount(int no)throws DataAccessException {
		int result = boardDAO.krViewCount(no);
		return result;
	}
	
	@Override
	public int krModi(ArticleVO vo)throws DataAccessException {
		int result = boardDAO.krModi(vo);
		return result;
	}
	
	@Override
	public int krDelete(int no)throws DataAccessException {
		return boardDAO.krDelete(no);
	}
	
	
	// 뉴스
	@Override
	public int newsArticleCount()throws DataAccessException {
		return boardDAO.newsArticleCount();
	}
	
	@Override
	public List newsList(int displayPost, int postNum)throws DataAccessException {
		return boardDAO.newsList(displayPost, postNum);
	}
	
	@Override
	public void newsWrite2(ArticleVO articleVO)throws DataAccessException {
		boardDAO.newsWrite2(articleVO);
	}
	
	@Override
	public ArticleVO newsView(int no)throws DataAccessException{
		return boardDAO.newsView(no);
	}
	
	@Override
	public int newsViewCount(int no)throws DataAccessException {
		int result = boardDAO.newsViewCount(no);
		return result;
	}
	
	@Override
	public int newsModi(ArticleVO vo)throws DataAccessException {
		int result = boardDAO.newsModi(vo);
		return result;
	}
	
	@Override
	public int newsDelete(int no)throws DataAccessException {
		return boardDAO.newsDelete(no);
	}
	
	
	
	// 자유
	@Override
	public int freeArticleCount()throws DataAccessException {
		return boardDAO.freeArticleCount();
	}
	
	@Override
	public List freeList(int displayPost, int postNum)throws DataAccessException {
		return boardDAO.freeList(displayPost, postNum);
	}
	
	@Override
	public void freeWrite2(ArticleVO articleVO)throws DataAccessException {
		boardDAO.freeWrite2(articleVO);
	}
	
	@Override
	public ArticleVO freeView(int no)throws DataAccessException{
		return boardDAO.freeView(no);
	}
	
	@Override
	public int freeViewCount(int no)throws DataAccessException {
		int result = boardDAO.freeViewCount(no);
		return result;
	}
	
	@Override
	public int freeModi(ArticleVO vo)throws DataAccessException {
		int result = boardDAO.freeModi(vo);
		return result;
	}
	
	@Override
	public int freeDelete(int no)throws DataAccessException {
		return boardDAO.freeDelete(no);
	}
	
	
	
}
