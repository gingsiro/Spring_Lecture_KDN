package com.kdn.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kdn.model.dao.BoardDao;
import com.kdn.model.dao.BoardDaoImpl;
import com.kdn.model.domain.Board;
import com.kdn.model.domain.BoardException;
import com.kdn.model.domain.FileBean;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;

public class BoardServiceImpl implements BoardService {
	BoardDao dao = new BoardDaoImpl();

	
	public void add(Board board) {

		Connection con = null;
		try {
			con = DBUtil.getConnection();
			
			int bno = dao.getBoardNo(con);
			board.setNo(bno);
			
			dao.add(con, board);
			List<FileBean> files = board.getFiles();
			if(files != null){
				dao.addFiles(con, files, bno);
			}
			
			con.commit();			
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(con);
			throw new BoardException("게시글 작성 중 오류");
		} finally {
			DBUtil.close(con);
		}
		
	}

	
	public void update(Board board) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			dao.update(con, board);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException("게시글 수정 중 오류");
		} finally {
			DBUtil.close(con);
		}
	}
	
	
	public void remove(int no) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			dao.removeFiles(con, no);
			dao.remove(con, no);
			
			con.commit();			
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(con);
			throw new BoardException("게시글 삭제 중 오류");
		} finally {
			DBUtil.close(con);
		}
	}

	
	public Board search(int no) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			
			return dao.search(con, no);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException("게시글 검색 중 오류");
		} finally {
			DBUtil.close(con);
		}
	}

	
	public List<Board> searchAll(PageBean bean) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			//int total = dao.getCount(con, bean);
			return dao.searchAll(con, bean);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException("게시글 검색 중 오류");
		} finally {
			DBUtil.close(con);
		}
	}

}
