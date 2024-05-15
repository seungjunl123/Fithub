package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.model.dto.SearchCondition;
import com.ssafy.project.model.dto.Video;

public interface VideoService {
	public abstract Video getVideo(String id);

	public abstract List<Video> getList();

	public abstract List<Video> search(SearchCondition condition);
}
