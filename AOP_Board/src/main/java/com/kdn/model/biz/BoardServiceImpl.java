package com.kdn.model.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kdn.model.dao.BoardDaoImpl;
import com.kdn.model.domain.Board;
import com.kdn.model.domain.UpdateException;
import com.kdn.model.domain.FileBean;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;
import com.kdn.util.PageUtility;

public class BoardServiceImpl implements BoardService {
	private BoardDao  dao;
	
	public BoardServiceImpl() {
	}

	public BoardServiceImpl(BoardDao dao) {
		this.dao = dao;
	}
	
	public BoardDao getDao() {
		return dao;
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	public void add(Board board, String dir) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			
			int bno = dao.getBoardNo(con);
			board.setNo(bno);
			
			dao.add(con, board);
			List<FileBean> files = board.getFiles();
			if(files!=null){
				dao.addFiles(con, files, bno);
			}
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(con);
			throw new UpdateException("게시글 작성 중 오류 발생");
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
			throw new UpdateException("게시글 수정 중 오류 발생");
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
			throw new UpdateException("게시글 삭제 중 오류 발생");
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
			throw new UpdateException("게시글 검색 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}
	public List<Board> searchAll(PageBean bean) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			int total = dao.getCount(con, bean);
			PageUtility  bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPagelink(bar.getPageBar());
			return dao.searchAll(con, bean);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateException("게시글 검색 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}
}
