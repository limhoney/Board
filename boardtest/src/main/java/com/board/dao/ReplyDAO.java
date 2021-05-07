package com.board.dao;

import java.util.List;

import com.board.vo.ReplyVO;

public interface ReplyDAO {

	// コメント照会
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	// コメント作成
	public void writdReply(ReplyVO vo) throws Exception;
	
	// コメント修正
	public void updateReply(ReplyVO vo) throws Exception;
	
	// コメント削除
	public void deleteReply(ReplyVO vo) throws Exception;
	
	// コメント照会
	public ReplyVO selectReply(int rno) throws Exception;
}
