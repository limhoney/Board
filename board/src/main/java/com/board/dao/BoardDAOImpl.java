package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";

	// 掲示物リスト
	@Override
	public List<BoardVO> list() throws Exception {	
		
		return sql.selectList(namespace + ".list");
	}

	// 掲示物作成
	@Override
	public void write(BoardVO vo) throws Exception {
			
		sql.insert(namespace + ".write", vo);
	}

	// 掲示物照会
	@Override
	public BoardVO view(int bno) throws Exception {
	
		return sql.selectOne(namespace + ".view", bno);
	}

	// 掲示物修正
	@Override
	public void modify(BoardVO vo) throws Exception {
		sql.update(namespace + ".modify", vo);
	}

	// 掲示物削除
	@Override
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete", bno);
	}

	
	
	// 掲示物の総本数
	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");	
	}

	
	
	// 掲示物リスト + ページング
	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {

		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sql.selectList(namespace + ".listPage", data);
	}

	
	
	// 掲示物リスト + ページング + 検索
	@Override
	public List<BoardVO> listPageSearch(
			int displayPost, int postNum, String searchType, String keyword) throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectList(namespace + ".listPageSearch", data);
	}
	
	// 掲示物の総本数 + 検索
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectOne(namespace + ".searchCount", data);	
	}

		

}
