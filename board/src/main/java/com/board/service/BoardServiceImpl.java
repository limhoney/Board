package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// 掲示物リスト
	@Override
	public List<BoardVO> list() throws Exception {

		return dao.list();
	}

	// 掲示物作成
	@Override
	public void write(BoardVO vo) throws Exception {
		
		dao.write(vo);
	}

	// 掲示物照会
	@Override
	public BoardVO view(int bno) throws Exception {

		return dao.view(bno);
	}

	// 掲示物修正
	@Override
	public void modify(BoardVO vo) throws Exception {
		
		dao.modify(vo);
	}

	// 掲示物削除
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}

	
	
	// 掲示物の総本数
	@Override
	public int count() throws Exception {
		return dao.count();
	}

	
	
	// 掲示物リスト + ページング
	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}

	
	
	// 掲示物リスト + ページング + 検索
	@Override
	public List<BoardVO> listPageSearch(
			int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return  dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	
	// 掲示物の総本数 + 検索
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		return dao.searchCount(searchType, keyword);
	}
}
