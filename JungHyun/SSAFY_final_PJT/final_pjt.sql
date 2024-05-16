-- 초기화용
-- DROP DATABASE IF EXISTS `final_pjt`;

CREATE DATABASE IF NOT EXISTS `final_pjt` CHAR SET utf8mb4;
USE `final_pjt`;

CREATE TABLE IF NOT EXISTS `user`(
	-- 회원 가입 시 필수 요소만 NOT NULL 조건
	-- UNIQUE로 중복 방지
    -- 표준 최대값 255
	user_name VARCHAR(20) NOT NULL,
	user_id VARCHAR(60) PRIMARY KEY NOT NULL,
    user_email VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(60) NOT NULL,
    -- 0~255로 제한
    user_age TINYINT NOT NULL,
    user_img VARCHAR(255),
    -- M or F
    user_sex CHAR(1) NOT NULL,
    -- 최대 5글자, 소수점 아래 2자리까지 (프론트에서 제한 걸어야 함. 오류 방지)
    user_goalWeight DOUBLE(5, 2),
    user_nowWeight DOUBLE(5, 2),
    user_isadmin BOOLEAN DEFAULT FALSE NOT NULL
);

INSERT INTO user (user_name, user_id, user_email, user_password, user_age, user_img, user_sex, user_goalWeight, user_nowWeight, user_isadmin)
VALUES
("김싸피", "ssafy", "", "ThankyouBUBU", "https://www.youtube.com/embed/gMaB-fG4u4g"),
("swRNeYw1JkY", "하루 15분! 전신 칼로리 불태우는 다이어트 운동","전신", "ThankyouBUBU", "https://www.youtube.com/embed/swRNeYw1JkY"),
("54tTYO-vU2E", "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "상체", "ThankyouBUBU", "https://www.youtube.com/embed/54tTYO-vU2E"),
("QqqZH3j_vH0", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "상체", "ThankyouBUBU", "https://www.youtube.com/embed/QqqZH3j_vH0"),
("tzN6ypk6Sps", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "하체", "김강민", "https://www.youtube.com/embed/tzN6ypk6Sps"),
("u5OgcZdNbMo", "저는 하체 식주의자 입니다", "하체", "GYM종국", "https://www.youtube.com/embed/u5OgcZdNbMo"),
("PjGcOP-TQPE", "11자복근 복부 최고의 운동 [복근 핵매운맛]", "복부", "ThankyouBUBU", "https://www.youtube.com/embed/PjGcOP-TQPE"),
("7TLk7pscICk", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "복부", "SomiFit", "https://www.youtube.com/embed/7TLk7pscICk");


CREATE TABLE IF NOT EXISTS `board`(
	board_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    board_boardType TINYINT NOT NULL,
    board_title VARCHAR(255) NOT NULL,
    board_content MEDIUMTEXT NOT NULL,
    board_writer VARCHAR(60) NOT NULL,
    board_like INT DEFAULT 0 NOT NULL,
    board_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    board_viewCnt INT DEFAULT 0 NOT NULL,
    FOREIGN KEY (board_writer) REFERENCES `user`(user_id)
);

CREATE TABLE IF NOT EXISTS `reply`(
	reply_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    reply_boardNo INT NOT NULL,
    reply_writer VARCHAR(60) NOT NULL,
    reply_content MEDIUMTEXT NOT NULL,
    reply_like INT DEFAULT 0 NOT NULL,
    reply_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (reply_boardNo) REFERENCES `board`(board_id),
    FOREIGN KEY (reply_writer) REFERENCES `user`(user_id)
);

-- 게시글 카테고리
CREATE TABLE IF NOT EXISTS `board_tag`(
	-- 게시판 넘버
    category_id INT PRIMARY KEY NOT NULL,
    -- 말머리
    category_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES `board`(board_boardType)
);

-- 대댓글 테이블 구현
CREATE TABLE IF NOT EXISTS `rereply`(
	rereply_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    rereply_reply_id INT NOT NULL,
    rereply_boardNo INT NOT NULL,
    rereply_writer VARCHAR(60) NOT NULL,
    rereply_content MEDIUMTEXT NOT NULL,
    rereply_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (rereply_boardNo) REFERENCES `board`(board_id),
    FOREIGN KEY (rereply_writer) REFERENCES `user`(user_id),
    FOREIGN KEY (rereply_reply_id) REFERENCES `reply`(reply_id)
);

-- 게시글 좋아요
CREATE TABLE IF NOT EXISTS `board_likes` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    board_id INT NOT NULL,
    user_id VARCHAR(60) NOT NULL,
    FOREIGN KEY (board_id) REFERENCES `board`(board_id),
    FOREIGN KEY (user_id) REFERENCES `user`(user_id),
    UNIQUE KEY (board_id, user_id) -- 한 사용자가 한 게시글에 한 번만 추천할 수 있도록 유니크 제약 추가
);

-- 댓글 좋아요
CREATE TABLE IF NOT EXISTS `reply_likes` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reply_id INT NOT NULL,
    user_id VARCHAR(60) NOT NULL,
    FOREIGN KEY (reply_id) REFERENCES `reply`(reply_id),
    FOREIGN KEY (user_id) REFERENCES `user`(user_id),
    UNIQUE KEY (reply_id, user_id) -- 한 사용자가 한 댓글에 한 번만 추천할 수 있도록 유니크 제약 추가
);

CREATE TABLE IF NOT EXISTS `exercise` (
	exercise_id INT AUTO_INCREMENT PRIMARY KEY,
    exercise_name VARCHAR(60) NOT NULL,
    exercise_check INT NOT NULL,
    exercise_cal INT NOT NULL,
    exercise_time INT NOT NULL
);


-- 테스트용 데이터 입력


SELECT * FROM `user`;
SELECT * FROM `board`;
SELECT * FROM `reply`;