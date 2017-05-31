package com.kdn.model.domain;

/**
 * 웹의 한 페이지를 표시하기 위한 정보
 */
public class PageBean {
	/** 조회 조건 */
	private String key;
	/** 검색 단어 */
	private String word;
	/** 현재 페이지 */
	private int pageNo;
	/** 한 페이지에 보여줄 데이터 개수 */
	private int interval = 5;
	/** 현재 페이지 시작 번호 */
	private int start = 1;
	/** 현재 페이지 끝 번호 */
	private int end = interval;

	public PageBean() {	}

	public PageBean(String key, String word, int pageNo) {
		this.key = key;
		this.word = word;
		this.pageNo = pageNo;
	}
	
	public PageBean(String key, String word, String pageNo) {
		this.key = key;
		this.word = word;
		try {
			this.pageNo = Integer.parseInt(pageNo);
		} catch (Exception e) {
			this.pageNo = 1; // pageNo가 null이거나 unbound로 들어오면 1로 설정
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getStart() {
		if (pageNo > 1) {
			start = ( pageNo - 1 ) * interval + 1;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		if(pageNo > 1) {
			end = start + interval - 1;
		}
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
