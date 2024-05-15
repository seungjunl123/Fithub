package com.ssafy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.model.dto.Review;
import com.ssafy.project.model.dto.SearchCondition;
import com.ssafy.project.model.dto.User;
import com.ssafy.project.model.dto.Video;
import com.ssafy.project.service.ReviewService;
import com.ssafy.project.service.UserService;
import com.ssafy.project.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServlet;

@RestController
@RequestMapping("/ssafit")
@Tag(name="ReviewController", description = "SSAFIT CRUD")
public class ReviewController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   @Autowired
    private VideoService Vservice;
   @Autowired
    private ReviewService Rservice;
   @Autowired
    private UserService Uservice;
   
   // 전체 video 리스트 출력
   @GetMapping("/video")
   @Operation(summary = "전체 영상 리스트", description = "전체 영상 리스트 출력")
   public ResponseEntity<?> selectAllVideo(){
      List<Video> list = Vservice.getList();
      return new ResponseEntity<>(list, HttpStatus.OK);
   }
   
   // 비디오 하나의 정보 가져오기
   @GetMapping("/video/{youtubeId}/info")
   @Operation(summary = "비디오 하나의 정보 가져오기", description = "영상 정보 출력")
   public ResponseEntity<?> selectOneVideo(@PathVariable("youtubeId") String youtubeId){
      Video video = Vservice.getVideo(youtubeId);
      System.out.println(video);
      return new ResponseEntity<>(video, HttpStatus.OK);
   }
   
   // 조회수나 부위에 따라서 리스트 나열
   @GetMapping("/video/search")
   @Operation(summary = "영상 조회", description = "영상 부위 조건에 따른 조회")
   public ResponseEntity<?> list(@Parameter(description = "검색 조건") @RequestBody SearchCondition condition){
      List<Video> list = Vservice.search(condition); //검색 조회
      
      if(list == null || list.size() == 0) {
         return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
   }
   
//   // 유저 리스트 출력
//   @GetMapping("/user")
//   public ResponseEntity<?> userlist(){
//      List<User> list = Uservice.selectAll();
//      return new ResponseEntity<List<User>>(list,HttpStatus.OK);
//   }
   
   // 영상 Id에 따른 리뷰 리스트 출력
   @GetMapping("/video/{youtubeId}")
   public ResponseEntity<?> list(@PathVariable("youtubeId") String youtubeId){
      List<Review> result = Rservice.getList(youtubeId);
      return new ResponseEntity<List<Review>>(result, HttpStatus.OK);
   }
   
   // 비디오 별 리뷰에서 한개의 리뷰 선택
   @GetMapping("/video/{youtubeId}/{reviewNo}")
   public ResponseEntity<?> seletReview(@PathVariable("reviewNo") int reviewNo){
      Review review =Rservice.getReview(reviewNo);
      return new ResponseEntity<Review>(review, HttpStatus.OK);
   }
   
   // 리뷰 등록
   @PostMapping("/video/{youtubeId}")
   public ResponseEntity<?> registReview(@PathVariable("youtubeId") String youtubeId, @RequestBody Review review){
      review.setYoutubeId(youtubeId);
      System.out.println(review);
      Rservice.writeReview(review);
      return new ResponseEntity<Review>(HttpStatus.CREATED);
   }
   
   // 리뷰 수정
   @PutMapping("/video/{youtubeId}/{reviewNo}")
   public ResponseEntity<?> updateReview(@PathVariable("reviewNo") int reviewNo, @RequestBody Review review){
	   System.out.println(review);
	   Rservice.modifyReview(reviewNo, review);
      return new ResponseEntity<Review>(HttpStatus.OK);
   }
   
   // 리뷰 삭제
   @DeleteMapping("/video/{youtubeId}/{reviewNo}")
      public ResponseEntity<?> deleteReview(@PathVariable("reviewNo") int reviewNo){
         Rservice.removeReview(reviewNo);
         return new ResponseEntity<Void>(HttpStatus.OK);
      }
   
}