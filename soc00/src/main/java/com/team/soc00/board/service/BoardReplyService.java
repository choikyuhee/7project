package com.team.soc00.board.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.team.soc00.board.vo.BoardReplyVO;

public interface BoardReplyService {

	public List<BoardReplyVO> replyList(int no)throws DataAccessException;
	
	public void insertReply(BoardReplyVO vo)throws DataAccessException;
	
	
	//�����౸ ���
	public List<BoardReplyVO> krReplyList(int no)throws DataAccessException;
	
	public void insertKrReply(BoardReplyVO vo)throws DataAccessException;
	
	//����
	public List<BoardReplyVO> newsReplyList(int no)throws DataAccessException;
	
	public void insertNewsReply(BoardReplyVO vo)throws DataAccessException;
	
	//����
	public List<BoardReplyVO> freeReplyList(int no)throws DataAccessException;
	
	public void insertFreeReply(BoardReplyVO vo)throws DataAccessException;
}
