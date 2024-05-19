package com.cjp.model.dao;

import java.util.List;

import com.cjp.model.dto.Board;
import com.cjp.model.dto.SearchCondition;

public interface BoardDao {
	// 전체 게시글을 조회
	public List<Board> selectAll();

	// ID에 해당하는 게시글 하나 가져오기
	public Board selectOne(int id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int id);

	// 추천수 증가
	public void upLike(String UserId,int boardId);

	// 추천수 감소
	public void downLike(String UserId,int boardId);

	// 검색 기능
	public List<Board> search(SearchCondition searchCondition);

}
