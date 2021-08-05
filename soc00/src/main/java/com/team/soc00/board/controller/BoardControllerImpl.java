package com.team.soc00.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.member.vo.MemberVO;
import com.team.soc00.board.service.BoardService;
import com.team.soc00.board.vo.ArticleVO;


@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;
	
	//해외축구게시판
	@Override
	@RequestMapping(value="/board/osSoccer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView osSoccer(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List allList = boardService.osSoccerList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allList", allList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/osWrite.do", method=RequestMethod.POST)
	public String osWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		boardService.osWrite2(articleVO);
		return "redirect:/board/osSoccer.do";
	}
	
	/*
	 * @Override
	 * 
	 * @RequestMapping(value="/board/osView.do", method= {RequestMethod.POST,
	 * RequestMethod.GET}) public String osView(@RequestParam("no") int no, Model
	 * model, HttpServletRequest req, HttpServletResponse res)throws Exception {
	 * req.setCharacterEncoding("utf-8");
	 * res.setContentType("text/html; charset=utf-8"); int result =
	 * boardService.osView(no); model.addAttribute("views", result);
	 * System.out.println(result); return "redirect:/board/osView.do"; }
	 */
	
	@Override
	@RequestMapping(value="/board/osView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView osView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = boardService.osViewCount(no);
		articleVO = boardService.osView(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/osModiView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView osModiView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		articleVO = boardService.osView(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/osModi.do", method=RequestMethod.POST)
	public ModelAndView osModi(@ModelAttribute("article") ArticleVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0; 
		result = boardService.osModi(vo);
		ModelAndView mav = new ModelAndView("redirect:/board/osSoccer.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/osDelete.do", method=RequestMethod.GET)
	public ModelAndView osDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.osDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/board/osSoccer.do");
		return mav;
	}
	/*
	@Override
	@RequestMapping(value="/board/osList.do", method=RequestMethod.GET)
	public void getOsList(Model model)throws Exception {
		List<ArticleVO> osList = null;
		osList = boardService.s1Count();
	}
	*/

	//국내축구게시판
	@Override
	@RequestMapping(value="/board/krSoccer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView krSoccer(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List allList = boardService.krSoccerList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allList", allList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/krWrite.do", method=RequestMethod.POST)
	public String krWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		boardService.krWrite2(articleVO);
		return "redirect:/board/krSoccer.do";
	}
	
	@Override
	@RequestMapping(value="/board/krView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView krView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		articleVO = boardService.krView(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		return mav;
	}
	
	
	//뉴스게시판
	@Override
	@RequestMapping(value="/board/news.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView news(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List allList = boardService.newsList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allList", allList);
		return mav;
	}
	
	//자유게시판
	@Override
	@RequestMapping(value="/board/free.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView free(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List allList = boardService.freeList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allList", allList);
		return mav;
	}
	
	
	@RequestMapping(value="/board/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}


}
