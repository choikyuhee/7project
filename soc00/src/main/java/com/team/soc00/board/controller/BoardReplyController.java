package com.team.soc00.board.controller;

import com.team.soc00.board.vo.BoardReplyVO;

public interface BoardReplyController {

	public String insertOsReply(BoardReplyVO vo)throws Exception;
	
	//�����౸ ���
	public String insertKrReply(BoardReplyVO vo)throws Exception;
	
	//����
	public String insertNewsReply(BoardReplyVO vo)throws Exception;
	
	//����
	public String insertFreeReply(BoardReplyVO vo)throws Exception;
	
}
