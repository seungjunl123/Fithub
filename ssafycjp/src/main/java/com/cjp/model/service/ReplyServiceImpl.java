package com.cjp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjp.model.dao.ReplyDao;
import com.cjp.model.dto.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private final ReplyDao replyDao;

	@Autowired
	public ReplyServiceImpl(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<Reply> getReplyList(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeReply(Reply reply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeReply(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyReply(Reply reply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLikeUp(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLikeDown(int id) {
		// TODO Auto-generated method stub
		
	}

}
