package com.team.soc00.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.soc00.board.service.BoardReplyService;
import com.team.soc00.board.vo.BoardReplyVO;

@Controller("boardRecplyController")
public class BoardReplyControllerImpl implements BoardReplyController {

	@Autowired
	private BoardReplyService boardReplyService;
	@Autowired
	private BoardReplyVO boardReplyVO;
	
	@Override
	@RequestMapping(value="/board/insertOsReply.do", method=RequestMethod.POST)
	public String insertOsReply(BoardReplyVO vo)throws Exception {
		boardReplyService.insertReply(vo);
		return "redirect:/board/osView.do?no=" + vo.getNo();
	}
	
	//�����౸ ���
	@Override
	@RequestMapping(value="/board/insertKrReply.do", method=RequestMethod.POST)
	public String insertKrReply(BoardReplyVO vo)throws Exception {
		boardReplyService.insertKrReply(vo);
		return "redirect:/board/krView.do?no=" + vo.getNo();
	}
	
	//����
	@Override
	@RequestMapping(value="/board/insertNewsReply.do", method=RequestMethod.POST)
	public String insertNewsReply(BoardReplyVO vo)throws Exception {
		boardReplyService.insertNewsReply(vo);
		return "redirect:/board/newsView.do?no=" + vo.getNo();
	}
	
	//����
	@Override
	@RequestMapping(value="/board/insertFreeReply.do", method=RequestMethod.POST)
	public String insertFreeReply(BoardReplyVO vo)throws Exception {
		boardReplyService.insertFreeReply(vo);
		return "redirect:/board/freeView.do?no=" + vo.getNo();
	}
	
}
