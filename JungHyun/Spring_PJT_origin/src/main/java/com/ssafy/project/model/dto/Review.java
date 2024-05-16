package com.ssafy.project.model.dto;

import java.util.Date;

public class Review {
	private int reviewNo;
	private String youtubeId;
	private String userId;
	private String title;
	private String content;
	private String regDate;
	private int viewCnt;
	
	
	public Review() {
		
	}
	
	public Review(String title, String content) {
		super();
		this.title = title;
		this.content = content;
		this.regDate = new Date().toString();
		this.viewCnt = 0;
	}
	
	public Review(String youtubeId, String userId, String title, String content) {
		super();
		this.youtubeId = youtubeId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.regDate = new Date().toString();
		this.viewCnt = 0;
	}


	public Review(int reviewNo, String youtubeId, String userId, String title, String content, String regDate,
			int viewCnt) {
		super();
		this.reviewNo = reviewNo;
		this.youtubeId = youtubeId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.regDate = new Date().toString();
		this.viewCnt = viewCnt;
	}




	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getYoutubeId() {
		return youtubeId;
	}


	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public int getViewCnt() {
		return viewCnt;
	}


	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}


	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", youtubeId=" + youtubeId + ", userId=" + userId + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}
	
}
