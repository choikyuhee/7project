package com.team.soc00.board.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.team.soc00.board.vo.BoardReplyVO;

public interface BoardReplyService {

	public List<BoardReplyVO> replyList(int no)throws DataAccessException;
	
	public void insertReply(BoardReplyVO vo)throws DataAccessException;
	
	
	//국내축구 댓글
	public List<BoardReplyVO> krReplyList(int no)throws DataAccessException;
	
	public void insertKrReply(BoardReplyVO vo)throws DataAccessException;
	
	//뉴스
	public List<BoardReplyVO> newsReplyList(int no)throws DataAccessException;
	
	public void insertNewsReply(BoardReplyVO vo)throws DataAccessException;
	
	//자유
	public List<BoardReplyVO> freeReplyList(int no)throws DataAccessException;
	
	public void insertFreeReply(BoardReplyVO vo)throws DataAccessException;
}
