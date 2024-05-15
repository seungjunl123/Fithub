package com.cjp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjp.model.dao.BoardDao;
import com.cjp.model.dto.Board;
import com.cjp.model.dto.SearchCondition;

@Service
public class ReplyServiceImpl implements BoardService {

	private final BoardDao boardDao;

	@Autowired
	public ReplyServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id + "번 게시글을 읽어옵니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void writeBoard(Board board) {
//		board.setId(1000);
		System.out.println("게시글 작성합니다.");
		boardDao.insertBoard(board);
//		boardDao.insertBoard(board);
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

	@Override
	public void updateLikeUp(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLikeDown(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHateUp(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHateDown(int id) {
		// TODO Auto-generated method stub
		
	}

}
