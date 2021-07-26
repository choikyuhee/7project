package com.team.soc00.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.shop.service.ShopService;
import com.team.soc00.shop.vo.ShopVO;

@Controller("shopController")
public class ShopControllerImpl implements ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopVO shopVO;

	@Override
	@RequestMapping(value="/shop/shopList.do", method = RequestMethod.GET)
	public ModelAndView shopList(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		List shopList = shopService.shopList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("shopList", shopList);
		return mav;

	}
	
	@Override
	@RequestMapping(value="/shop/prodInfo.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView prodInfo(@RequestParam("p_no") int p_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception{
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		shopVO = shopService.prodInfo(p_no);
		ModelAndView mav = new ModelAndView();
		System.out.println(shopVO);
		mav.addObject("prodInfo", shopVO);
		return mav;
	}
	
	@RequestMapping(value="/shop/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
}
