package com.team.soc00.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.qna.vo.QnaVO;

public interface QnaController {

	public ModelAndView help(HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView qnaWrite(QnaVO qnaVO,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView question(HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView qnaView(@RequestParam("q_no") int q_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
}
