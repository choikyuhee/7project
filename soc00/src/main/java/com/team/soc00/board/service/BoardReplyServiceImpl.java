package com.team.soc00.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.team.soc00.board.dao.BoardReplyDAO;
import com.team.soc00.board.vo.BoardReplyVO;

@Service("boardReplyService")
public class BoardReplyServiceImpl implements BoardReplyService {

	@Autowired
	private BoardReplyDAO boardReplyDAO;
	
	@Override
	public List<BoardReplyVO> replyList(int no)throws DataAccessException {
		return boardReplyDAO.replyList(no);
	}
	
	@Override
	public void insertReply(BoardReplyVO vo)throws DataAccessException {
		boardReplyDAO.insertReply(vo);
	}
	
	//국내축구
	@Override
	public List<BoardReplyVO> krReplyList(int no)throws DataAccessException {
		return boardReplyDAO.krReplyList(no);
	}
	
	@Override
	public void insertKrReply(BoardReplyVO vo)throws DataAccessException {
		boardReplyDAO.insertKrReply(vo);
	}
	
	//뉴스
	@Override
	public List<BoardReplyVO> newsReplyList(int no)throws DataAccessException {
		return boardReplyDAO.newsReplyList(no);
	}
	
	@Override
	public void insertNewsReply(BoardReplyVO vo)throws DataAccessException {
		boardReplyDAO.insertNewsReply(vo);
	}
	
	//자유
	@Override
	public List<BoardReplyVO> freeReplyList(int no)throws DataAccessException {
		return boardReplyDAO.freeReplyList(no);
	}
	
	@Override
	public void insertFreeReply(BoardReplyVO vo)throws DataAccessException {
		boardReplyDAO.insertFreeReply(vo);
	}
}
