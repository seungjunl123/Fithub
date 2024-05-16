CREATE DATABASE Spring_PJT CHAR SET utf8mb4;
USE Spring_PJT;

CREATE TABLE SSAFIT_user (
    user_id VARCHAR(50) PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(40) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(40) NOT NULL
);

CREATE TABLE SSAFIT_video (
    id varchar(40) PRIMARY KEY NOT NULL,
    title varchar(100) NOT NULL,
    part varchar(10) NOT NULL,
    channelName varchar(30) NOT NULL,
    url varchar(100) NOT NULL,
    viewCnt int DEFAULT 0
    );

INSERT INTO SSAFIT_video (id, title, part, channelName, url)
VALUES
("gMaB-fG4u4g", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "전신", "ThankyouBUBU", "https://www.youtube.com/embed/gMaB-fG4u4g"),
("swRNeYw1JkY", "하루 15분! 전신 칼로리 불태우는 다이어트 운동","전신", "ThankyouBUBU", "https://www.youtube.com/embed/swRNeYw1JkY"),
("54tTYO-vU2E", "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "상체", "ThankyouBUBU", "https://www.youtube.com/embed/54tTYO-vU2E"),
("QqqZH3j_vH0", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "상체", "ThankyouBUBU", "https://www.youtube.com/embed/QqqZH3j_vH0"),
("tzN6ypk6Sps", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "하체", "김강민", "https://www.youtube.com/embed/tzN6ypk6Sps"),
("u5OgcZdNbMo", "저는 하체 식주의자 입니다", "하체", "GYM종국", "https://www.youtube.com/embed/u5OgcZdNbMo"),
("PjGcOP-TQPE", "11자복근 복부 최고의 운동 [복근 핵매운맛]", "복부", "ThankyouBUBU", "https://www.youtube.com/embed/PjGcOP-TQPE"),
("7TLk7pscICk", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "복부", "SomiFit", "https://www.youtube.com/embed/7TLk7pscICk");

-- 테스트를 위해 첫 번째 영상 조회수를 100으로 한다.
UPDATE SSAFIT_video SET viewCnt = 100 WHERE id = "swRNeYw1JkY";

CREATE TABLE SSAFIT_review (
    review_No INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    youtube_Id varchar(40) NOT NULL,
    user_id VARCHAR(50) -- NOT NULL
    ,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    view_cnt INT DEFAULT 0 NOT NULL,
    regDate DATETIME DEFAULT CURRENT_TIMESTAMP,

-- FOREIGN KEY (user_id) REFERENCES ssafit_user(user_id),
FOREIGN KEY(youtube_Id) REFERENCES SSAFIT_video(id)
);

SELECT * FROM SSAFIT_video;
SELECT * FROM SSAFIT_review;
INSERT INTO SSAFIT_review (youtube_Id, user_id, title, content, view_cnt) 
VALUES
("gMaB-fG4u4g", "ssafy", "좋아용", "좋아요!!", 0),
("gMaB-fG4u4g", "test", "싫어요", "별로예요~", 2);

CREATE TABLE SSAFIT_follower (
    user_id VARCHAR(50) NOT NULL,
    follow_id VARCHAR(50) NOT NULL,

PRIMARY KEY(user_id,follow_id),

FOREIGN KEY (user_id) REFERENCES ssafit_user (user_id),
FOREIGN KEY (follow_id) REFERENCES ssafit_user (user_id)
);

CREATE TABLE SSAFIT_ZZIM (
    user_id VARCHAR(50) NOT NULL,
    youtubeId char(11) NOT NULL,
    PRIMARY KEY(user_id, youtubeId),
    FOREIGN KEY(user_id) REFERENCES SSAFIT_user(user_id),
    FOREIGN KEY(youtubeId) REFERENCES SSAFIT_video(id)
    );