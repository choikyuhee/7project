package com.team.soc00.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.qna.service.QnaService;
import com.team.soc00.qna.vo.FaqVO;
import com.team.soc00.qna.vo.QnaVO;

@Controller("qnaController")
public class QnaControllerImpl implements QnaController {
	
	@Autowired
	QnaService qnaService;
	@Autowired
	QnaVO qnaVO;
	@Autowired
	FaqVO faqVO;
	
	@Override
	@RequestMapping(value="/cs/help.do", method=RequestMethod.GET)
	public ModelAndView help(HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		List faqList = qnaService.faqList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("faqList", faqList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cs/faqWrite.do", method=RequestMethod.POST)
	public ModelAndView faqWrite(@ModelAttribute("faq") FaqVO faq,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = qnaService.faqWrite(faq);
		ModelAndView mav = new ModelAndView("redirect:/cs/help.do");
		return mav;
		
	}
	
	@Override
	@RequestMapping(value="/cs/faqView.do", method=RequestMethod.GET)
	public ModelAndView faqView(@RequestParam("f_no") int f_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		faqVO = qnaService.faqView(f_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("faq", faqVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cs/faqModiView.do", method=RequestMethod.GET)
	public ModelAndView faqModiView(@RequestParam("f_no") int f_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		faqVO = qnaService.faqView(f_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("faq", faqVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cs/faqModi.do", method=RequestMethod.POST)
	public ModelAndView faqModi(@ModelAttribute("faq") FaqVO faq,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = qnaService.faqModi(faq);
		ModelAndView mav = new ModelAndView("redirect:/cs/help.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cs/faqDelete.do", method=RequestMethod.GET)
	public ModelAndView faqDelete(@RequestParam("f_no") int f_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		qnaService.faqDelete(f_no);
		ModelAndView mav = new ModelAndView("redirect:/cs/help.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cs/qnaWrite.do", method=RequestMethod.POST)
	public ModelAndView qnaWrite(@ModelAttribute("qna") QnaVO qna,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = qnaService.qnaWrite(qna);
		ModelAndView mav = new ModelAndView("redirect:/cs/question.do");
		return mav;
		
	}
	
	@Override
	@RequestMapping(value="/cs/question.do", method=RequestMethod.GET)
	public ModelAndView question(HttpServletRequest req, HttpServletResponse res)throws Exception{
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		List qnaList = qnaService.qnaList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("qnaList", qnaList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cs/qnaView.do", method=RequestMethod.GET)
	public ModelAndView qnaView(@RequestParam("q_no") int q_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		qnaVO = qnaService.qnaView(q_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("question", qnaVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cs/qnaModiView.do", method=RequestMethod.GET)
	public ModelAndView qnaModiView(@RequestParam("q_no") int q_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		qnaVO = qnaService.qnaView(q_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("question", qnaVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/cs/qnaModi.do", method=RequestMethod.POST)
	public ModelAndView qnaModi(@ModelAttribute("qna") QnaVO qna,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = qnaService.qnaModi(qna);
		ModelAndView mav = new ModelAndView("redirect:/cs/question.do");
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/cs/qnaDelete.do", method=RequestMethod.GET)
	public ModelAndView qnaDelete(@RequestParam("q_no") int q_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		qnaService.qnaDelete(q_no);
		ModelAndView mav = new ModelAndView("redirect:/cs/question.do");
		return mav;
	}
	
	@RequestMapping(value="/cs/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
}
