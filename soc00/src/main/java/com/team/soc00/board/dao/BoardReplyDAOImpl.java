package com.team.soc00.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc00.board.vo.BoardReplyVO;

@Repository("boardReplyDAO")
public class BoardReplyDAOImpl implements BoardReplyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardReplyVO> replyList(int no)throws DataAccessException {
		return sqlSession.selectList("mapper.boardReply.osReplyList", no); 
	}
	
	@Override
	public void insertReply(BoardReplyVO vo)throws DataAccessException {
		sqlSession.insert("mapper.boardReply.insertOsReply", vo);
	}
	
	
	//국내축구 댓글
	@Override
	public List<BoardReplyVO> krReplyList(int no)throws DataAccessException {
		return sqlSession.selectList("mapper.boardReply.krReplyList", no); 
	}
	
	@Override
	public void insertKrReply(BoardReplyVO vo)throws DataAccessException {
		sqlSession.insert("mapper.boardReply.insertKrReply", vo);
	}
	
	
	//뉴스
	@Override
	public List<BoardReplyVO> newsReplyList(int no)throws DataAccessException {
		return sqlSession.selectList("mapper.boardReply.newsReplyList", no); 
	}
	
	@Override
	public void insertNewsReply(BoardReplyVO vo)throws DataAccessException {
		sqlSession.insert("mapper.boardReply.insertNewsReply", vo);
	}
	
	//자유
	@Override
	public List<BoardReplyVO> freeReplyList(int no)throws DataAccessException {
		return sqlSession.selectList("mapper.boardReply.freeReplyList", no); 
	}
	
	@Override
	public void insertFreeReply(BoardReplyVO vo)throws DataAccessException {
		sqlSession.insert("mapper.boardReply.insertFreeReply", vo);
	}
}
