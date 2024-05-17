package com.cjp.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "댓글 DTO")
public class Reply {
	private int id;
	private int boardNo;
	private String writer;
	private String content;
	private int like;
	private String regDate;
	
	public Reply() {
		
	}
	
	public Reply(int boardNo,String writer, String content, String regDate) {
		this.boardNo = boardNo;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", boardNo=" + boardNo + ", writer=" + writer + ", content=" + content + ", like="
				+ like + ", regDate=" + regDate + "]";
	}
	
	
	
}
