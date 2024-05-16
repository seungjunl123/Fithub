package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.model.dto.Review;

public interface ReviewService {
   // 전체글 가져오기
   public abstract List<Review> getList(String youtubeId);

   // 게시글 하나 가져오기
   public abstract Review getReview(int reviewNo);

   // 게시글 작성
   public abstract void writeReview(Review review);

   // 게시글 수정
   public abstract void modifyReview(int reviewNo, Review review);

   // 게시글 삭제
   public abstract void removeReview(int reviewNo);
}