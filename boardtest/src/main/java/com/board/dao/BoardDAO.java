package com.board.dao;

import java.util.List;
import java.util.Map;
import com.board.vo.BoardVO;
import com.board.vo.SearchCriteria;

public interface BoardDAO {

	// 掲示板作成
	public void write(BoardVO boardVO) throws Exception;
	
	// 掲示板照会
	public List<BoardVO> list(SearchCriteria scri) throws Exception;

	// 総本数
	public int listCount(SearchCriteria scri) throws Exception;
	
	// 掲示板照会
	public BoardVO read(int bno) throws Exception;
	
	// 掲示板修正
	public void update(BoardVO boardVO) throws Exception;
	
	// 掲示板削除
	public void delete(int bno) throws Exception;
	
	// 添付ファイルアップロード
	public void insertFile(Map<String, Object> map) throws Exception;
	
	// 添付ファイル照会
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	
	// 添付ファイルのダウンロード
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;

	// 添付ファイル修正
	public void updateFile(Map<String, Object> map) throws Exception;
	
	// 掲示板のアクセス数
	public void boardHit(int bno) throws Exception;
}
