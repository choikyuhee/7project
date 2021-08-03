package com.team.soc00.shop.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.shop.service.ShopService;
import com.team.soc00.shop.vo.OrderVO;
import com.team.soc00.shop.vo.ShopVO;

@Controller("shopController")
public class ShopControllerImpl implements ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopVO shopVO;
	@Autowired
	private OrderVO orderVO;
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final String SHOP_IMAGE_REPO = "C:\\choiProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\soc00\\resources";
	
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
		mav.addObject("prodInfo", shopVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/shop/prodReg.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String prodReg(ShopVO shopVO,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		
		shopService.prodReg(shopVO);
		return "redirect:/shop/shopList.do";
	}
	
	/*
	@Override
	@ResponseBody
	public ResponseEntity prodReg1(MultipartHttpServletRequest mreq, HttpServletResponse res)throws Exception {
		mreq.setCharacterEncoding("utf-8");
		Map<String,Object> prodMap = new HashMap<String,Object>();
		Enumeration enu = mreq.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = mreq.getParameter(name);
			prodMap.put(name, value);
		}
		
		String imageFileName = upload(mreq);
		prodMap.put("imageFileName", imageFileName);
		
	}
	*/
	
	
	@Override
	@RequestMapping(value="/shop/prodBuy.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView prodBuy(@RequestParam("p_no") int p_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		shopVO = shopService.prodInfo(p_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("prodInfo", shopVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/shop/buy.do", method=RequestMethod.POST)
	public ModelAndView buy(@ModelAttribute("order") OrderVO order,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = shopService.buy(order);
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@Override
	@RequestMapping(value="/shop/orderList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView orderList(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List orderList = shopService.orderList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("orderList", orderList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/shop/orderView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView orderView(@RequestParam("o_no") int o_no,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		orderVO = shopService.orderView(o_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("order", orderVO);
		return mav;
	}
	
	@RequestMapping(value="/shop/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	private String upload(MultipartHttpServletRequest mreq, HttpServletResponse res)throws Exception {
		String imageFileName = null;
		Iterator<String> fileNames = mreq.getFileNames();
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = mreq.getFile(fileName);
			imageFileName = mFile.getOriginalFilename();
			File file = new File(SHOP_IMAGE_REPO + "\\" + "upload" + "\\" + fileName);
			if(mFile.getSize() != 0) {
				if(!file.exists()) {
					file.getParentFile().mkdirs();
					mFile.transferTo(new File(SHOP_IMAGE_REPO + "\\" + "upload" + "\\" + fileName));
				}
			}
		}
		return imageFileName;
	}
}
