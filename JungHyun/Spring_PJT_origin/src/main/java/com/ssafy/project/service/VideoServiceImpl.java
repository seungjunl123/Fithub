package com.ssafy.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.dao.VideoDao;
import com.ssafy.project.model.dto.SearchCondition;
import com.ssafy.project.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService{
	@Autowired
	private VideoDao videoDao;

	@Override
	public Video getVideo(String id) {
		videoDao.updateViewCnt(id);
		return videoDao.selectOne(id);
	}

	@Override
	public List<Video> getList() {
		return videoDao.selectAll();
	}

	@Override
	public List<Video> search(SearchCondition condition) {
		return videoDao.search(condition);
	}


}
