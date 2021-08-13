package com.team.soc00.shop.controller;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.team.soc00.member.vo.MemberVO;
import com.team.soc00.shop.service.ShopService;
import com.team.soc00.shop.vo.CartListVO;
import com.team.soc00.shop.vo.CartVO;
import com.team.soc00.shop.vo.OrderDetailVO;
import com.team.soc00.shop.vo.OrderListVO;
import com.team.soc00.shop.vo.OrderVO;
import com.team.soc00.shop.vo.ShopVO;
import com.team.soc00.utils.FileUpload;

@Controller("shopController")
public class ShopControllerImpl implements ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopVO shopVO;
	@Autowired
	private OrderVO orderVO;
	@Autowired
	private CartVO cartVO;
	@Autowired
	private CartListVO cartListVO;
	@Autowired
	private OrderDetailVO orderDetailVO;
	@Autowired
	private OrderListVO orderListVO;
	@Resource(name="uploadPath")
	private String uploadPath;

		
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
	@ResponseBody
	@RequestMapping(value="/shop/insertCart.do", method=RequestMethod.POST)
	public String insertCart(CartVO vo, HttpServletRequest req, HttpServletResponse res)throws Exception {
		shopService.insertCart(vo);
		return "redirect:/shop/shopList.do";
	}
	
	@Override
	@ResponseBody
	@RequestMapping(value="/shop/deleteCart.do", method=RequestMethod.POST)
	public int deleteCart(@RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception {	 
		int result = 0;
		int cartNum = 0;
		for(String i : chArr) {   
			cartNum = Integer.parseInt(i);
			cart.setC_no(cartNum);
			shopService.deleteCart(cart);
			}   
		result = 1;
		return result;  
	}
	
	@Override
	@RequestMapping(value="/shop/cartList.do", method=RequestMethod.GET)
	public ModelAndView cartList(@RequestParam("u_id") String u_id,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		List cartList = shopService.cartList(u_id);
		mav.addObject("cartList", cartList);
		session.setAttribute("cartSession", cartList);
		return mav;
	}
	
	@Override
	@ResponseBody
	@RequestMapping(value="/shop/orderPage.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView orderPage(@RequestParam(value = "chbox[]") List<String> chArr, CartListVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		ModelAndView mav = new ModelAndView();
		int result = 0;
		int c_no = 0;
		for(String i : chArr) {   
			c_no = Integer.parseInt(i);
			vo.setC_no(c_no);
			shopService.orderPageView(vo);
			System.out.println(c_no);
			}
		result = 0;
		return mav;
	}
	
		
	@Override
	@RequestMapping(value="/shop/prodReg.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String prodReg(ShopVO shopVO, @RequestParam("p_filename") MultipartFile p_filename,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = FileUpload.calcPath(imgUploadPath);
		String fileName = null;

		if(p_filename.getOriginalFilename() != null && p_filename.getOriginalFilename() != "") {
			fileName = FileUpload.fileUpload(imgUploadPath, p_filename.getOriginalFilename(), p_filename.getBytes(), ymdPath); 
			
			shopVO.setPr_filename(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			shopVO.setP_thumb(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
		} 
		else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			
			shopVO.setPr_filename(fileName);
			shopVO.setP_thumb(fileName);
		}

		shopService.prodReg(shopVO);
		return "redirect:/shop/shopList.do";
	}
	
	
	
	@Override
	@RequestMapping(value="/shop/buy.do", method=RequestMethod.POST)
	public String buy(HttpSession session, OrderVO order, OrderDetailVO od_vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		MemberVO member = (MemberVO)session.getAttribute("member");
		String u_id = member.getU_id();
		System.out.println(u_id);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		 
		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}
		 
		String o_no = ymd + "_" + subNum;
		
		order.setO_no(o_no);
		
		shopService.buy(order);
		
		od_vo.setO_no(o_no);
		shopService.buyDetail(od_vo);
		shopService.deleteAllCart(u_id);
		return "redirect:/shop/orderList.do";
	}
	
	@Override
	@RequestMapping(value="/shop/orderList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView orderList(HttpSession session, HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		MemberVO member = (MemberVO)session.getAttribute("member");
		String u_id = member.getU_id();
		List orderList = shopService.orderList(u_id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("orderList", orderList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/shop/orderListView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView orderListView(@RequestParam("o_no")String o_no, HttpSession session, OrderVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		MemberVO member = (MemberVO)session.getAttribute("member");
		String u_id = member.getU_id();
		
		vo.setU_id(u_id);
		vo.setO_no(o_no);
		List<OrderListVO> orderView = shopService.orderListView(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderView", orderView);
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/shop/orderView111.do", method= {RequestMethod.POST, RequestMethod.GET})
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
	
	
}
