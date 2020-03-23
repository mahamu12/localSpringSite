package com.spring.client.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	public SqlSession session;

	// 글 목록 구현
	@Override
	public List<BoardVO> boardList() {
		return session.selectList("boardList");
	}

	// 글 입력 구현
	@Override
	public int boardInsert(BoardVO bvo) {
		return session.insert("boardInsert", bvo);
	}

	// 글 상세 구현
	@Override
	public BoardVO boardDetail(BoardVO bvo) {
		return (BoardVO) session.selectOne("boardDetail", bvo);
	}

	// 비밀번호 확인 구현
	@Override
	public int pwdConfirm(BoardVO bvo) {
		return (Integer) session.selectOne("pwdConfirm", bvo);
	}

	// 글 수정 구현

	@Override
	public int boardUpdate(BoardVO bvo) {
		return session.update("BoardUpdate", bvo);
	}

	// 글 삭제 구현

	@Override
	public int boardDelete(int b_num) {
		return session.delete("boardDelete", b_num);
	}

}
