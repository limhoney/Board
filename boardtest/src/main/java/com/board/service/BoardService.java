package com.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.board.vo.BoardVO;
import com.board.vo.SearchCriteria;

public interface BoardService {

	// 掲示板作成
	public void write(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception;

	// 掲示板照会
	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	
	// 総本数
	public int listCount(SearchCriteria scri) throws Exception;
	
	// 掲示板照会
	public BoardVO read(int bno) throws Exception;
	
	// 掲示板修正
	public void update(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception;
	
	// 掲示板削除
	public void delete(int bno) throws Exception;
	
	// 添付ファイル照会
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	
	// 添付ファイルのダウンロード
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
}
