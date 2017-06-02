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
	
	@RequestMapping(value="insertBoardForm.do", method=RequestMethod.GET)
	public String insertBoardForm(Model model){
		model.addAttribute("content", "board/insertBoard.jsp");
		return "index";
	}

	@RequestMapping(value="insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(Board board, HttpServletRequest request){
		String dir = request.getRealPath("upload/");
		boardService.add(board, dir);
		return "redirect:listBoard.do";
		//insert update등을 하고서 리스트로 갈때 listBoard를 호출하면 안되고
		//listBoard.do를 호출해야한다.
	}
	
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




