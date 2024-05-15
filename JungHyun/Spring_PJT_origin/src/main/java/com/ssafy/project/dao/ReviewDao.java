package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.model.dto.Review;

public interface ReviewDao {
   public abstract List<Review> selectAll(String youtubeId);

   public abstract Review selectOne(int reviewNo);

   public abstract void insertReview(Review review);

   public abstract void updateReview(int reviewNo, Review review);

   public abstract void deleteReview(int reviewNo);

   public abstract void updateViewCnt(int reviewNo);
   
   public abstract void updateReview(int reviewNo, String content);
}