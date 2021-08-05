package com.team.soc00.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.shop.vo.CartVO;
import com.team.soc00.shop.vo.OrderVO;
import com.team.soc00.shop.vo.ShopVO;

public interface ShopController {
	
	public ModelAndView shopList(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView prodInfo(@RequestParam("p_no") int p_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public String prodReg(ShopVO shopVO, @RequestParam("pr_filename") MultipartFile file,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public String insertCart(CartVO vo,
			HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	public ModelAndView cartList(@RequestParam("u_id") String u_id,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView prodBuy(@RequestParam("p_no") int p_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView buy(@ModelAttribute("order") OrderVO order,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView orderList(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView orderView(@RequestParam("o_no") int o_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
}
