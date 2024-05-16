package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.model.dto.SearchCondition;
import com.ssafy.project.model.dto.Video;

public interface VideoDao {
	public abstract Video selectOne(String id);

	public abstract void updateViewCnt(String id);

	public abstract List<Video> selectAll();

	public abstract List<Video> search(SearchCondition condition);
}
