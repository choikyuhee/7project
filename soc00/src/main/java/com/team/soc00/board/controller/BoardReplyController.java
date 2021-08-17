package com.team.soc00.board.controller;

import com.team.soc00.board.vo.BoardReplyVO;

public interface BoardReplyController {

	public String insertOsReply(BoardReplyVO vo)throws Exception;
	
	//국내축구 댓글
	public String insertKrReply(BoardReplyVO vo)throws Exception;
	
	//뉴스
	public String insertNewsReply(BoardReplyVO vo)throws Exception;
	
	//자유
	public String insertFreeReply(BoardReplyVO vo)throws Exception;
	
}
