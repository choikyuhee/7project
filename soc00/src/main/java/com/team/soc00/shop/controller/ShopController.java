package com.team.soc00.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ShopController {
	
	public ModelAndView shopList(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
