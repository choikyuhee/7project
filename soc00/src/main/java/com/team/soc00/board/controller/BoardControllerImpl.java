package com.team.soc00.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.board.service.BoardReplyService;
import com.team.soc00.board.service.BoardService;
import com.team.soc00.board.vo.ArticleVO;
import com.team.soc00.board.vo.BoardReplyVO;
import com.team.soc00.board.controller.BoardPage;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;
	@Autowired
	private BoardReplyService boardReplyService;
	
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
	@RequestMapping(value="/board/osList.do", method=RequestMethod.GET)
	public void osList(@RequestParam("num") int num, Model model)throws Exception {
		
		BoardPage page = new BoardPage();
		
		page.setNum(num);
		page.setCount(boardService.articleCount());
		
		
		List allList = null;
		allList = boardService.osListPage(page.getDisplayPost(), page.getPostNum());
		model.addAttribute("allList", allList);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
	}
	
	@Override
	@RequestMapping(value="/board/osWrite.do", method=RequestMethod.POST)
	public String osWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		boardService.osWrite2(articleVO);
		return "redirect:/board/osList.do?num=1";
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
		
		List<BoardReplyVO> replyList = null;
		replyList = boardReplyService.replyList(no);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		mav.addObject("replyList", replyList);
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
		ModelAndView mav = new ModelAndView("redirect:/board/osList.do?num=1");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/osDelete.do", method=RequestMethod.GET)
	public ModelAndView osDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.osDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/board/osList.do?num=1");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/osDelete2.do", method=RequestMethod.GET)
	public ModelAndView osDelete2(@RequestParam("no") int no, ArticleVO vo,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.newsDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/admin/userArticle.do?u_id="+vo.getU_id());
		return mav;
	}
	

	//국내축구게시판
	@Override
	@RequestMapping(value="/board/krSoccer.do", method = RequestMethod.GET)
	public ModelAndView krSoccer(@RequestParam("num") int num, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		BoardPage page = new BoardPage();
		
		page.setNum(num);
		page.setCount(boardService.krArticleCount());
		
		
		List allList = null;
		allList = boardService.krSoccerList(page.getDisplayPost(), page.getPostNum());
		mav.addObject("allList", allList);
		mav.addObject("page", page);
		mav.addObject("select", num);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/krWrite.do", method=RequestMethod.POST)
	public String krWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		boardService.krWrite2(articleVO);
		return "redirect:/board/krSoccer.do?num=1";
	}
	
	@Override
	@RequestMapping(value="/board/krView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView krView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = boardService.krViewCount(no);
		articleVO = boardService.krView(no);
		
		List<BoardReplyVO> replyList = null;
		replyList = boardReplyService.krReplyList(no);
		System.out.println(replyList.toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		mav.addObject("replyList", replyList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/krModiView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView krModiView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		articleVO = boardService.krView(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/krModi.do", method=RequestMethod.POST)
	public ModelAndView krModi(@ModelAttribute("article") ArticleVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0; 
		result = boardService.krModi(vo);
		ModelAndView mav = new ModelAndView("redirect:/board/krSoccer.do?num=1");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/krDelete.do", method=RequestMethod.GET)
	public ModelAndView krDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.krDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/board/krSoccer.do?num=1");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/krDelete2.do", method=RequestMethod.GET)
	public ModelAndView krDelete2(@RequestParam("no") int no, ArticleVO vo,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.newsDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/admin/userArticle.do?u_id="+vo.getU_id());
		return mav;
	}
	
	
	//뉴스게시판
	@Override
	@RequestMapping(value="/board/news.do", method = RequestMethod.GET)
	public ModelAndView news(@RequestParam("num") int num, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		BoardPage page = new BoardPage();
		
		page.setNum(num);
		page.setCount(boardService.newsArticleCount());
		
		
		List allList = null;
		allList = boardService.newsList(page.getDisplayPost(), page.getPostNum());
		mav.addObject("allList", allList);
		mav.addObject("page", page);
		mav.addObject("select", num);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/newsWrite.do", method=RequestMethod.POST)
	public String newsWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		boardService.newsWrite2(articleVO);
		return "redirect:/board/news.do?num=1";
	}
	
	@Override
	@RequestMapping(value="/board/newsView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView newsView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = boardService.newsViewCount(no);
		articleVO = boardService.newsView(no);
		
		List<BoardReplyVO> replyList = null;
		replyList = boardReplyService.newsReplyList(no);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		mav.addObject("replyList", replyList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/newsModiView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView newsModiView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		articleVO = boardService.newsView(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/newsModi.do", method=RequestMethod.POST)
	public ModelAndView newsModi(@ModelAttribute("article") ArticleVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0; 
		result = boardService.newsModi(vo);
		ModelAndView mav = new ModelAndView("redirect:/board/news.do?num=1");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/newsDelete.do", method=RequestMethod.GET)
	public ModelAndView newsDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.newsDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/board/news.do?num=1");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/newsDelete2.do", method=RequestMethod.GET)
	public ModelAndView newsDelete2(@RequestParam("no") int no, ArticleVO vo,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.newsDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/admin/userArticle.do?u_id="+vo.getU_id());
		return mav;
	}
	

	//자유게시판
	@Override
	@RequestMapping(value="/board/free.do", method = RequestMethod.GET)
	public ModelAndView free(@RequestParam("num") int num, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		BoardPage page = new BoardPage();
		
		page.setNum(num);
		page.setCount(boardService.freeArticleCount());
		
		
		List allList = null;
		allList = boardService.freeList(page.getDisplayPost(), page.getPostNum());
		mav.addObject("allList", allList);
		mav.addObject("page", page);
		mav.addObject("select", num);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/freeWrite.do", method=RequestMethod.POST)
	public String freeWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		boardService.freeWrite2(articleVO);
		return "redirect:/board/free.do?num=1";
	}
	
	@Override
	@RequestMapping(value="/board/freeView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView freeView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int result = 0;
		result = boardService.freeViewCount(no);
		articleVO = boardService.freeView(no);
		
		List<BoardReplyVO> replyList = null;
		replyList = boardReplyService.freeReplyList(no);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		mav.addObject("replyList", replyList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/freeModiView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView freeModiView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		articleVO = boardService.freeView(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/freeModi.do", method=RequestMethod.POST)
	public ModelAndView freeModi(@ModelAttribute("article") ArticleVO vo,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		int result = 0; 
		result = boardService.freeModi(vo);
		ModelAndView mav = new ModelAndView("redirect:/board/free.do?num=1");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/freeDelete.do", method=RequestMethod.GET)
	public ModelAndView freeDelete(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.freeDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/board/free.do?num=1");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/freeDelete2.do", method=RequestMethod.GET)
	public ModelAndView freeDelete2(@RequestParam("no") int no, ArticleVO vo,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		boardService.freeDelete(no);
		ModelAndView mav = new ModelAndView("redirect:/admin/userArticle.do?u_id="+vo.getU_id());
		return mav;
	}
	
	// form
	@RequestMapping(value="/board/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}


}
