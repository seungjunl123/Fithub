package com.cjp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjp.model.dao.ReplyDao;
import com.cjp.model.dto.Reply;
import com.cjp.model.dto.SearchCondition;

@Service
public class ReplyServiceImpl implements ReplyService {

	private final ReplyDao replyDao;

	@Autowired
	public ReplyServiceImpl(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<Reply> getReplyList(int boardNo) {
		return replyDao.selectAll(boardNo);
	}

	@Transactional
	@Override
	public void writeReply(Reply reply) {
		replyDao.insertReply(reply);
	}

	@Transactional
	@Override
	public void removeReply(int id) {
		replyDao.deleteReply(id);
	}

	@Transactional
	@Override
	public void modifyReply(Reply reply) {
		replyDao.updateReply(reply);
	}

	@Override
	public void updateLikeUp(int id) {
		replyDao.likeUp(id);
	}

	@Override
	public void updateLikeDown(int id) {
		replyDao.LikeDown(id);
	}

}
