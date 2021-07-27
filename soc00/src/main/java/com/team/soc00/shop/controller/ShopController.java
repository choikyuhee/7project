package com.team.soc00.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.shop.vo.ShopVO;

public interface ShopController {
	
	public ModelAndView shopList(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView prodInfo(@RequestParam("p_no") int p_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public String prodReg(ShopVO shopVO, HttpServletRequest req, HttpServletResponse res)throws Exception;
}
