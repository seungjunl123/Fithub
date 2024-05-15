package com.ssafy.project.model.dto;

public class SearchCondition {
	private String part;
	private String word;

	public SearchCondition() {
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "SearchCondition [part=" + part + ", word=" + word + "]";
	}
}
