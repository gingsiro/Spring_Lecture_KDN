package com.kdn.model.domain;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable{
	private static final long serialVersionUID = 1L;
	private int no;
	private String id;
	private String title;
	private String regdate;
	private String contents;
	private List<FileBean>  files;    //조인 정보
	public Board(){
		System.out.println("Board() 호출 됨");
	}
	public Board(int no, String id, String title) {
		this.no = no;
		this.id = id;
		this.title = title;
	}
	public Board(int no, String id, String title, String regdate, String contents) {
		System.out.println("Board(int no, String id, String title, String regdate, String contents) 호출 됨");
		this.no = no;
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.contents = contents;
	}
	public Board(int no, String id, String title, String regdate, String contents, List<FileBean> files) {
		this.no = no;
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.contents = contents;
		this.files = files;
	}
	
	public void test_init(){
		System.out.println("test_init() 호출됨....");
	}
	public void test_destroy(){
		System.out.println("test_destroy() 호출됨....");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=").append(no).append(", id=").append(id)
				.append(", title=").append(title)
				.append(", regdate=").append(regdate).append(", contents=")
				.append(contents).append(", files=")
				.append(files).append("]");
		return builder.toString();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public List<FileBean> getFiles() {
		return files;
	}
	public void setFiles(List<FileBean> files) {
		this.files = files;
	}
	
	
}
