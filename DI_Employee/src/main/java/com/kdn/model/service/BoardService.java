package com.kdn.model.service;

import java.util.List;

import com.kdn.model.domain.Board;
import com.kdn.model.domain.PageBean;

public interface BoardService {
	public void add(Board board);
	public void update(Board board);
	public void remove(int no);
	public Board search(int no);
	public List<Board> searchAll(PageBean bean);
}
