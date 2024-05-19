package com.cjp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjp.model.dao.BoardDao;
import com.cjp.model.dto.Board;
import com.cjp.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private final BoardDao boardDao;

	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id + "번 게시글을 읽어옵니다.");
		boardDao.updateViewCnt(id); // 조회수 증가
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성합니다.");
		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public void removeBoard(int id) {
		System.out.println(id+"번 게시글을 삭제하겠습니다.");
		boardDao.deleteBoard(id);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정");
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> search(SearchCondition searchCondition) {
		return boardDao.search(searchCondition);
	}
	
	@Transactional
	@Override
	public void updateLikeUp(String userId,int boardId) {
		boardDao.upLike(userId,boardId);
	}
	
	@Transactional
	@Override
	public void updateLikeDown(String userId,int boardId) {
		boardDao.downLike(userId,boardId);
		
	}

}
