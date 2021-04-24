package com.board.domain;

public class Page {
	
	// 現在ページ番号
	private int num;
	
	// 掲示物の総本数
	private int count;
	
	// 1ページに出力する掲示物の数
	private int postNum = 10;
	
	// 下段ページング番号 
	private int pageNum;
	
	// 出力する掲示物
	private int displayPost;
	
	// 一度に表示するページング番号の数
	private int pageNumCnt = 10;
	
	// 表示されるページ番号の最後の番号
	private int endPageNum;
	
	// 表示されるページ番号の最初の番号
	private int startPageNum;
	
	// 次/前の表示可否
	private boolean prev;
	private boolean next;
	
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setCount(int count) {
		this.count = count;
		
		dataCalc();
	}	
		
	public int getCount() {
		return count;
	}
	
	public int getPostNum() {
		return postNum;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	
	public int getDisplayPost() {
		return displayPost;
	}
	
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	
	public int getEndPageNum() {
		return endPageNum;
	}
	
	public int getStartPageNum() {
		return startPageNum;
	}
	
	public boolean getPrev() {
		return prev;
	}	
	
	public boolean getNext() {
		return next;
	}
	
	
	
	private void dataCalc() {
		
		// 最後の番号
		endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		
		// 開始番号
		startPageNum = endPageNum - (pageNumCnt - 1);
		
		// 最後の番号の再計算
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNumCnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		prev = startPageNum == 1 ? false : true;
		next = endPageNum * pageNumCnt >= count ? false : true;
		
		displayPost = (num - 1) * postNum;
		
	}
	
	
	public String getSearchTypeKeyword() {
		
		if(searchType.equals("") || keyword.equals("")) {
			return "";	
		} else {
			return "&searchType=" + searchType + "&keyword=" + keyword;	
		}
	}
	
	private String searchType;
	private String keyword;	
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;		
	}
	
	public String getSearchType() {
		return searchType;
	}	
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;		
	}	
	
	public String getKeyword() {
		return keyword;
	}
	
	
	
}
