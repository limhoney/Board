package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardService {

	// 掲示物リスト
	public List<BoardVO> list() throws Exception;
	
	// 掲示物作成
	public void write(BoardVO vo) throws Exception;

	// 掲示物照会
	public BoardVO view(int bno) throws Exception;

	// 掲示物修正
	public void modify(BoardVO vo) throws Exception;
	
	// 掲示物削除
	public void delete(int bno) throws Exception;
	
	
	
	// 掲示物の総本数
	public int count() throws Exception;

	
	
	// 掲示物リスト + ページング
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
	
	
	
	// 掲示物リスト + ページング + 検索
	public List<BoardVO> listPageSearch(
			int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	// 掲示物の総本数 + 検索
	public int searchCount(String searchType, String keyword) throws Exception;
}
