-- 초기화용
-- DROP DATABASE IF EXISTS `final_pjt`;

CREATE DATABASE IF NOT EXISTS `final_pjt` CHAR SET utf8mb4;
USE `final_pjt`;

-- 트리거
DELIMITER //
CREATE TRIGGER before_insert_category
BEFORE INSERT ON `category`
FOR EACH ROW
BEGIN
    DECLARE max_category TINYINT;
    
    -- 현재 postboard_id 그룹에서 가장 큰 category 값을 찾는다.
    SELECT IFNULL(MAX(category), 0) INTO max_category
    FROM `category`
    WHERE postboard_id = NEW.postboard_id;

    -- 새로 삽입될 row의 category 값을 설정한다.
    SET NEW.category = max_category + 1;
END;
//
DELIMITER ;


CREATE TABLE IF NOT EXISTS `user`(
	-- 회원 가입 시 필수 요소만 NOT NULL 조건
	-- UNIQUE로 중복 방지
    -- 표준 최대값 255
	user_name VARCHAR(20) NOT NULL,
	user_id VARCHAR(60) PRIMARY KEY,
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

-- 게시판
CREATE TABLE IF NOT EXISTS `postboard`(
	postboard_id INT AUTO_INCREMENT PRIMARY KEY,
    postboard_title VARCHAR(255) NOT NULL
);

-- 게시글 분류
CREATE TABLE IF NOT EXISTS `category`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    -- 게시판 넘버
    postboard_id INT NOT NULL,
    -- 말머리 넘버
    category TINYINT NOT NULL,
    -- 말머리
    category_name VARCHAR(100) NOT NULL,
    
    FOREIGN KEY (postboard_id) REFERENCES `postboard`(postboard_id),
    UNIQUE KEY (postboard_id, category)
);

-- 게시글
CREATE TABLE IF NOT EXISTS `board`(
	board_id INT AUTO_INCREMENT PRIMARY KEY,
    -- 게시글 종류 (말머리) 기본값 0 (일반 게시글)
    board_category TINYINT DEFAULT 0 NOT NULL,
    postboard_id INT NOT NULL,
    board_title VARCHAR(255) NOT NULL,
    board_content MEDIUMTEXT NOT NULL,
    board_writer VARCHAR(60) NOT NULL,
    board_like INT DEFAULT 0 NOT NULL,
    board_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    board_viewCnt INT DEFAULT 0 NOT NULL,
    FOREIGN KEY (board_writer) REFERENCES `user`(user_id),
    FOREIGN KEY (postboard_id) REFERENCES `postboard`(postboard_id)
);

-- 댓글
CREATE TABLE IF NOT EXISTS `reply`(
	reply_id INT PRIMARY KEY AUTO_INCREMENT,
    reply_board_id INT NOT NULL,
    reply_writer VARCHAR(60) NOT NULL,
    reply_content MEDIUMTEXT NOT NULL,
    reply_like INT DEFAULT 0 NOT NULL,
    reply_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (reply_board_id) REFERENCES `board`(board_id),
    FOREIGN KEY (reply_writer) REFERENCES `user`(user_id)
);

-- 대댓글
CREATE TABLE IF NOT EXISTS `rereply`(
	rereply_id INT PRIMARY KEY AUTO_INCREMENT,
    rereply_reply_id INT NOT NULL,
    rereply_board_id INT NOT NULL,
    rereply_writer VARCHAR(60) NOT NULL,
    rereply_content MEDIUMTEXT NOT NULL,
    rereply_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (rereply_board_id) REFERENCES `board`(board_id),
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

-- 운동
CREATE TABLE IF NOT EXISTS `exercise` (
	exercise_id INT AUTO_INCREMENT PRIMARY KEY,
    exercise_name VARCHAR(60) NOT NULL,
    exercise_check INT NOT NULL,
    exercise_cal INT NOT NULL,
    exercise_time INT NOT NULL
);


-- 테스트용 데이터 입력
INSERT INTO `postboard` (postboard_title) VALUES ('게시판1'), ('게시판2');

INSERT INTO `category` (postboard_id, category_name) VALUES
(1, '일반'), (1, '공지'), (1, '질문'), (2, '일반'), (2, '공지');


SELECT * FROM `user`;
SELECT * FROM `postboard`;
SELECT * FROM `category`;
SELECT * FROM `board`;
SELECT * FROM `reply`;
SELECT * FROM `rereply`;
SELECT * FROM `board_likes`;
SELECT * FROM `reply_likes`;
SELECT * FROM `exercise`;