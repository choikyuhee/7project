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
	public void osWrite2(ArticleVO articleVO)throws DataAccessException {
		boardDAO.osWrite2(articleVO);
	}
	
	@Override
	public ArticleVO osView(int no)throws DataAccessException{
		return boardDAO.osView(no);
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
	
	
	@Override
	public List<ArticleVO> krSoccerList() throws DataAccessException {
		List<ArticleVO> krSoccerList = boardDAO.krSoccerList();
		return krSoccerList;
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
	public List<ArticleVO> newsList() throws DataAccessException {
		List<ArticleVO> newsList = boardDAO.newsList();
		return newsList;
	}
	
	@Override
	public List<ArticleVO> freeList() throws DataAccessException {
		List<ArticleVO> freeList = boardDAO.freeList();
		return freeList;
	}
	
	
	
	
}
