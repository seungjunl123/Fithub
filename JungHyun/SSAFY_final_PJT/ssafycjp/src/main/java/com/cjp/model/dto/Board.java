package com.cjp.model.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "게시글 DTO")
public class Board {
	private int id;
	private int boardType;
	private String title;
	private String content;
	private String writer;
	private int like;
	private int hate;
	private LocalDateTime regDate;
	private int viewCnt;
	
	public Board() {
		
	}
	
	public Board(int boardType, String title, String content, String writer, LocalDateTime regDate) {
		this.boardType = boardType;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = LocalDateTime.now();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getHate() {
		return hate;
	}

	public void setHate(int hate) {
		this.hate = hate;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
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
		return "Board [id=" + id + ", boardType=" + boardType + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", like=" + like + ", hate=" + hate + ", RegDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}


}
