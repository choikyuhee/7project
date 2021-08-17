package com.team.soc00.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {

	public ModelAndView shopList(@RequestParam("num") int num, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView userArticle(@RequestParam("u_id")String u_id, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
}
