package com.team.soc00.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc00.board.vo.ArticleVO;


@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List osUserFind(String u_id)throws DataAccessException {
		return sqlSession.selectList("mapper.board.osUserFind", u_id);
	}
	
	@Override
	public List osSoccerList()throws DataAccessException{
		List<ArticleVO> osSoccerList = sqlSession.selectList("mapper.board.osSoccerList");
		return osSoccerList;
	}
	
	@Override
	public int articleCount()throws DataAccessException {
		return sqlSession.selectOne("mapper.board.articleCount");
	}
	
	@Override
	public List osListPage(int displayPost, int postNum)throws DataAccessException {
		
		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sqlSession.selectList("mapper.board.osListPage", data);
	}
	
	@Override
	public void osWrite2(ArticleVO articleVO) throws DataAccessException {
		sqlSession.insert("mapper.board.insertOsSoccer", articleVO);
	}
	
	@Override
	public ArticleVO osView(int no) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectOsView", no);
	}
	
	@Override
	public int osViewCount(int no)throws DataAccessException {
		return sqlSession.update("mapper.board.osViewCount", no);
	}
	
	@Override
	public int s1Count()throws DataAccessException {
		return sqlSession.selectOne("mapper.board.s1Count");
	}

	@Override
	public int osModi(ArticleVO vo)throws DataAccessException {
		int result = sqlSession.update("mapper.board.osModi", vo);
		return result;
	}
	
	@Override
	public int osDelete(int no)throws DataAccessException {
		int result = sqlSession.delete("mapper.board.osDelete", no);
		return result;
	}
	// 국내축구 
	
	@Override
	public List krUserFind(String u_id)throws DataAccessException {
		return sqlSession.selectList("mapper.board.krUserFind", u_id);
	}
	
	@Override
	public int krArticleCount()throws DataAccessException {
		return sqlSession.selectOne("mapper.board.krArticleCount");
	}
	
	@Override
	public List krSoccerList(int displayPost, int postNum)throws DataAccessException{
		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return  sqlSession.selectList("mapper.board.krSoccerList", data);
	}
	
	@Override
	public void krWrite2(ArticleVO articleVO) throws DataAccessException {
		sqlSession.insert("mapper.board.insertKrSoccer", articleVO);
	}
	
	@Override
	public ArticleVO krView(int no) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectKrView", no);
	}
	
	@Override
	public int krViewCount(int no)throws DataAccessException {
		return sqlSession.update("mapper.board.krViewCount", no);
	}
	
	@Override
	public int krModi(ArticleVO vo)throws DataAccessException {
		int result = sqlSession.update("mapper.board.krModi", vo);
		return result;
	}
	
	@Override
	public int krDelete(int no)throws DataAccessException {
		int result = sqlSession.delete("mapper.board.krDelete", no);
		return result;
	}
	
	// 뉴스
	
	@Override
	public List newsUserFind(String u_id)throws DataAccessException {
		return sqlSession.selectList("mapper.board.newsUserFind", u_id);
	}
	
	
	@Override
	public List newsList(int displayPost, int postNum)throws DataAccessException{
		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return  sqlSession.selectList("mapper.board.newsList", data);
	}
	
	@Override
	public int newsArticleCount()throws DataAccessException {
		return sqlSession.selectOne("mapper.board.newsArticleCount");
	}
	
	@Override
	public void newsWrite2(ArticleVO articleVO) throws DataAccessException {
		sqlSession.insert("mapper.board.insertNews", articleVO);
	}
	
	@Override
	public ArticleVO newsView(int no) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewsView", no);
	}
	
	@Override
	public int newsViewCount(int no)throws DataAccessException {
		return sqlSession.update("mapper.board.newsViewCount", no);
	}
	
	@Override
	public int newsModi(ArticleVO vo)throws DataAccessException {
		int result = sqlSession.update("mapper.board.newsModi", vo);
		return result;
	}
	
	@Override
	public int newsDelete(int no)throws DataAccessException {
		int result = sqlSession.delete("mapper.board.newsDelete", no);
		return result;
	}

	//자유
	
	@Override
	public List freeUserFind(String u_id)throws DataAccessException {
		return sqlSession.selectList("mapper.board.freeUserFind", u_id);
	}
	
	@Override
	public List freeList(int displayPost, int postNum)throws DataAccessException{
		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return  sqlSession.selectList("mapper.board.freeList", data);
	}
	
	@Override
	public int freeArticleCount()throws DataAccessException {
		return sqlSession.selectOne("mapper.board.freeArticleCount");
	}
	
	@Override
	public void freeWrite2(ArticleVO articleVO) throws DataAccessException {
		sqlSession.insert("mapper.board.insertFree", articleVO);
	}
	
	@Override
	public ArticleVO freeView(int no) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectFreeView", no);
	}
	
	@Override
	public int freeViewCount(int no)throws DataAccessException {
		return sqlSession.update("mapper.board.freeViewCount", no);
	}
	
	@Override
	public int freeModi(ArticleVO vo)throws DataAccessException {
		int result = sqlSession.update("mapper.board.freeModi", vo);
		return result;
	}
	
	@Override
	public int freeDelete(int no)throws DataAccessException {
		int result = sqlSession.delete("mapper.board.freeDelete", no);
		return result;
	}

}
