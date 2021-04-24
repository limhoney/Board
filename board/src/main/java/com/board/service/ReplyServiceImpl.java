package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.ReplyDAO;
import com.board.domain.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;
	
	// コメントリスト
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return dao.list(bno);
	}

	// コメント作成
	@Override
	public void write(ReplyVO vo) throws Exception {
		dao.write(vo);
	}

	// コメント修正
	@Override
	public void modify(ReplyVO vo) throws Exception {
		dao.modify(vo);
	}

	// コメント削除
	@Override
	public void delete(ReplyVO vo) throws Exception {
		dao.delete(vo);
	}

}
