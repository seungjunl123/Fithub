package com.cjp.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "게시글 DTO")
public class Board {
	private int id;
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int like;
	private int  hate;
	private String regDate;
	private int viewCnt;
	
	public Board(int boardNo, String title, String content, String writer, String regDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = dateFormat.format(new Date());
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
		return "Board [id=" + id + ", boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", like=" + like + ", hate=" + hate + ", RegDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}


}
