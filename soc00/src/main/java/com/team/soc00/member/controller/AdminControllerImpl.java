package com.team.soc00.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.board.service.BoardService;
import com.team.soc00.shop.controller.ShopPage;
import com.team.soc00.shop.service.ShopService;

@Controller
@RequestMapping(value="/admin/*")
public class AdminControllerImpl implements AdminController {
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminControllerImpl.class);
	
	@RequestMapping(value="/adminPage.do", method=RequestMethod.GET)
	public void adminPage() throws Exception {
	
	}
	
	@Override
	@RequestMapping(value="/admin/shopList.do", method = RequestMethod.GET)
	public ModelAndView shopList(@RequestParam("num") int num, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		AdminShopPage page = new AdminShopPage();
		
		page.setNum(num);
		page.setCount(shopService.shopListCount());
		
		
		List allList = null;
		allList = shopService.shopList1();
		
		mav.addObject("shopList", allList);
		mav.addObject("page", page);
		mav.addObject("select", num);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/admin/userArticle.do", method=RequestMethod.GET)
	public ModelAndView userArticle(@RequestParam("u_id")String u_id, HttpServletRequest request, HttpServletResponse response)throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List osList = null;
		osList = boardService.osUserFind(u_id);
		
		List krList = null;
		krList = boardService.krUserFind(u_id);
		
		List newsList = null;
		newsList = boardService.newsUserFind(u_id);
		
		List freeList = null;
		freeList = boardService.freeUserFind(u_id);
		
		mav.addObject("osList", osList);
		mav.addObject("krList", krList);
		mav.addObject("newsList", newsList);
		mav.addObject("freeList", freeList);
		
		return mav;
	}
}
