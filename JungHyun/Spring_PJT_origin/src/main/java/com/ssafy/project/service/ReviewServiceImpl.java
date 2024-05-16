package com.ssafy.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.dao.ReviewDao;
import com.ssafy.project.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
   @Autowired
   private ReviewDao reviewDao;

   private ReviewServiceImpl() {
   }

   @Override
   public List<Review> getList(String youtubeId) {
      return reviewDao.selectAll(youtubeId);
   }

   @Override
   public Review getReview(int reviewNo) {
      reviewDao.updateViewCnt(reviewNo);
      return  reviewDao.selectOne(reviewNo);
   }

   @Override
   public void writeReview(Review review) {
      reviewDao.insertReview(review);

   }

   @Override
   public void modifyReview(int reviewNo, Review review) {
      reviewDao.updateReview(reviewNo, review);
   }

   @Override
   public void removeReview(int reviewNo) {
      reviewDao.deleteReview(reviewNo);
   }
}