package com.board.dao;

import com.board.vo.MemberVO;

public interface MemberDAO {
	
	// 会員加入
	public void register(MemberVO vo) throws Exception;
	
	// ログイン
	public MemberVO login(MemberVO vo) throws Exception;
	
	// 会員情報修正
	public void memberUpdate(MemberVO vo)throws Exception;
	
	// 会員退会
	public void memberDelete(MemberVO vo)throws Exception;
	
	// パスワードチェック
	public int passChk(MemberVO vo) throws Exception;
	
	// ID重複チェック
	public int idChk(MemberVO vo) throws Exception;
}
