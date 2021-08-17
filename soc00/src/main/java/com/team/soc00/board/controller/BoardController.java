package com.team.soc00.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.board.vo.ArticleVO;

public interface BoardController {

	public ModelAndView osSoccer(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public void osList(@RequestParam("num") int num, Model model)throws Exception;
	
	public ModelAndView osModi(@ModelAttribute("article") ArticleVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView osDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;

	public String osWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView osView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;	
	
	public ModelAndView osModiView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	//국내축구
	public ModelAndView krSoccer(@RequestParam("num") int num, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public String krWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView krView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView krModi(@ModelAttribute("article") ArticleVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView krDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView krModiView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	// 뉴스
	public ModelAndView news(@RequestParam("num") int num, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public String newsWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView newsView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView newsModi(@ModelAttribute("article") ArticleVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView newsDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView newsModiView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	
	// 자유
	public ModelAndView free(@RequestParam("num") int num, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public String freeWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView freeView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView freeModi(@ModelAttribute("article") ArticleVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView freeDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView freeModiView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;


}
