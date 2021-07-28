package com.team.soc00.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.qna.vo.FaqVO;
import com.team.soc00.qna.vo.QnaVO;

public interface QnaController {

	public ModelAndView help(HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView faqWrite(@ModelAttribute("faq") FaqVO faq,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView faqView(@RequestParam("f_no") int f_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView faqModiView(@RequestParam("f_no") int f_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView faqModi(@ModelAttribute("faq") FaqVO faq,
			HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	public ModelAndView faqDelete(@RequestParam("f_no") int f_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView qnaWrite(QnaVO qnaVO,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView question(HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView qnaView(@RequestParam("q_no") int q_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView qnaModi(@ModelAttribute("qna") QnaVO qna,
			HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	public ModelAndView qnaDelete(@RequestParam("q_no") int q_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView qnaModiView(@RequestParam("q_no") int q_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
}
