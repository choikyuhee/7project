package com.team.soc00.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.team.soc00.board.vo.ArticleVO;

public interface BoardDAO {

	public List osSoccerList() throws DataAccessException;
	public void osWrite2(ArticleVO articleVO) throws DataAccessException;
	public ArticleVO osView(int no) throws DataAccessException;
	public int osModi(ArticleVO vo)throws DataAccessException;
	public int osDelete(int no)throws DataAccessException;
	public int s1Count()throws DataAccessException;
	public int osViewCount(int no)throws DataAccessException;
	
	
	public List krSoccerList() throws DataAccessException;
	public void krWrite2(ArticleVO articleVO) throws DataAccessException;
	public ArticleVO krView(int no) throws DataAccessException;
	
	
	public List newsList() throws DataAccessException;
	
	
	public List freeList() throws DataAccessException;

}
