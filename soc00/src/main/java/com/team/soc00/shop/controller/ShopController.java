package com.team.soc00.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.shop.vo.CartListVO;
import com.team.soc00.shop.vo.CartVO;
import com.team.soc00.shop.vo.OrderDetailVO;
import com.team.soc00.shop.vo.OrderVO;
import com.team.soc00.shop.vo.ShopVO;

public interface ShopController {
	
	public void shopList(@RequestParam("num") int num, Model model)throws Exception;
	
	
	
	public ModelAndView prodInfo(@RequestParam("p_no") int p_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView deleteProd(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public String prodModi(ShopVO vo, MultipartFile p_filename,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView prodModiView(@RequestParam("p_no") int p_no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public String prodReg(ShopVO shopVO, @RequestParam("pr_filename") MultipartFile file,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public String insertCart(CartVO vo,
			HttpServletRequest req, HttpServletResponse res) throws Exception;

	public int deleteCart(@RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception;
	
	public ModelAndView cartList(@RequestParam("u_id") String u_id,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView orderPage(@RequestParam("chbox[]") List<String> chArr, CartListVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public String buy(HttpSession session, OrderVO order, OrderDetailVO od_vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView orderList(HttpSession session, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView orderListView(@RequestParam("o_no")String o_no, HttpSession session, OrderVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView orderView(@RequestParam("o_no") int o_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception;
}
