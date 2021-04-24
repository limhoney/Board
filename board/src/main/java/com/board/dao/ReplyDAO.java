package com.board.dao;

import java.util.List;

import com.board.domain.ReplyVO;

public interface ReplyDAO {

	// コメントリスト
	public List<ReplyVO> list(int bno) throws Exception;
	
	// コメント作成
	public void write(ReplyVO vo) throws Exception;
	
	// コメント修正
	public void modify(ReplyVO vo) throws Exception;
	
	// コメント削除
	public void delete(ReplyVO vo) throws Exception;
}
