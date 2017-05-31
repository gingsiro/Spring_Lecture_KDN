package com.kdn;

import java.util.ArrayList;
import java.util.List;

import com.kdn.model.domain.Board;
import com.kdn.model.domain.FileBean;
import com.kdn.model.domain.PageBean;
import com.kdn.model.service.BoardService;
import com.kdn.model.service.BoardServiceImpl;

public class BoardTest {
	public static void print(List<Board> list){
		System.out.println("=====================게시글 목록=====================");
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	public static void main(String[] args) {
		BoardService service = new BoardServiceImpl();
		
		try {
			ArrayList<FileBean> files = new ArrayList<FileBean>();
			files.add(new FileBean("c.txt", "c.txt"));
			files.add(new FileBean("d.txt", "d.txt"));
			files.add(new FileBean("f.txt", "f.txt"));
			
			Board board = new Board(0, "kdg", "게시글 예제", null, "오늘 시험 잘 보세용", files);
			service.add(board);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		print(service.searchAll(new PageBean("all", null, 1)));
		
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
