package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.domain.ReplyVO;
import com.board.service.BoardService;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService service;
	
	@Inject
	private ReplyService replyService;

	// 掲示物リスト
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		List<BoardVO> list = null; 
		list = service.list();
		model.addAttribute("list", list);		 
	}
	
	// 掲示物作成
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWirte() throws Exception {
		 
	}
	
	// 掲示物作成
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String posttWirte(BoardVO vo) throws Exception {
		 service.write(vo);
		 
		 return "redirect:/board/list";
	}
	
	// 掲示物照会
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
		
		BoardVO vo = service.view(bno);
		 
		model.addAttribute("view", vo);
		 
		
		// コメント照会
		List<ReplyVO> reply = null;
		reply = replyService.list(bno);
		model.addAttribute("reply", reply);
		
	}
	
	// 掲示物修正
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {

		BoardVO vo = service.view(bno);
		 
		model.addAttribute("view", vo);
	}
	
	// 掲示物修正
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo) throws Exception {

		service.modify(vo);
		 
		 return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	// 掲示物削除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {
		
		service.delete(bno);		

		return "redirect:/board/list";
	} 
	
	
	
	// 掲示物リスト + ページング追加
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception {

		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.count());		
		
		List<BoardVO> list = null; 
		list = service.listPage(page.getDisplayPost(), page.getPostNum());
		
		model.addAttribute("list", list);
		
		
		model.addAttribute("page", page);
		
		model.addAttribute("select", num);
		
		
	}


	
	// 掲示物リスト+ページング追加+検索
	@RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
	public void getListPageSearch(Model model, @RequestParam("num") int num, 
			@RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword",required = false, defaultValue = "") String keyword
			) throws Exception {
	
		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.searchCount(searchType, keyword));
		
		// 検索タイプと検索ワード
		page.setSearchType(searchType);
		page.setKeyword(keyword);
				
		List<BoardVO> list = null; 
		list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
		
	}


}
