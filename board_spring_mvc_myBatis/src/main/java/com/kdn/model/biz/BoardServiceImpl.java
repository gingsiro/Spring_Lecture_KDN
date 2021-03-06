package com.kdn.model.biz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kdn.model.domain.Board;
import com.kdn.model.domain.FileBean;
import com.kdn.model.domain.PageBean;
import com.kdn.model.domain.UpdateException;
import com.kdn.util.PageUtility;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	@Qualifier("boardDao")
	private BoardDao dao;

	public void add(Board board, String dir) {
		try {
			int bno = dao.getBoardNo();
			board.setNo(bno);
			dao.add(board);
			
			List<FileBean> fileList = board.getFiles();
			if (fileList != null) {
				dao.addFiles(fileList, bno);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UpdateException("게시글 작성 중 오류 발생");
		} finally {
		}
	}

	@Override
	public void update(Board board) {
		try {
			dao.update(board);

		} catch (Exception e) {
			e.printStackTrace();
			throw new UpdateException("게시글 수정 중 오류 발생");
		} finally {
		}
	}

	public void remove(int no) {
		try {
			dao.removeFiles(no);
			dao.remove(no);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UpdateException("게시글 삭제 중 오류 발생");
		} finally {
		}
	}

	public Board search(int no) {
		try {
			return dao.search(no);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UpdateException("게시글 검색 중 오류 발생");
		} finally {
		}
	}

	public List<Board> searchAll(PageBean bean) {
		try {
			int total = dao.getCount(bean);

			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPagelink(bar.getPageBar());
			return dao.searchAll(bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UpdateException("게시글 전체 검색 중 오류 발생");
		} finally {
		}
	}
}
