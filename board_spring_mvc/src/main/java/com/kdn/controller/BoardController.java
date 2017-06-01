package com.kdn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdn.model.biz.BoardService;
import com.kdn.model.domain.Board;
import com.kdn.model.domain.PageBean;

@Controller
public class BoardController {
	@Autowired
	private BoardService  boardService;

	@RequestMapping(value="listBoard.do", method=RequestMethod.GET)
	public String listBoard(PageBean bean, Model model){
		
		List<Board> list = boardService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("content", "board/listBoard.jsp");
		
		return "index";
	}
	
	@RequestMapping(value="searchBoard.do", method=RequestMethod.GET)
	public String searchBoard(int no, Model model){
		Board board = boardService.search(no);
		model.addAttribute("board", board);
		model.addAttribute("content", "board/searchBoard.jsp");
		
		return "index";
	}
	
}




