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
    user_nowWeight DOUBLE(5, 2)
);

CREATE TABLE IF NOT EXISTS `board`(
	board_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    board_boardType TINYINT NOT NULL,
    board_title VARCHAR(255) NOT NULL,
    board_content MEDIUMTEXT NOT NULL,
    board_writer VARCHAR(60) NOT NULL,
    board_like INT DEFAULT 0 NOT NULL,
    board_hate INT DEFAULT 0 NOT NULL,
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
-- CREATE TABLE IF NOT EXISTS `rereply`(
-- 	reply_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
--     reply_boardNo INT NOT NULL,
--     reply_writer VARCHAR(60) NOT NULL,
--     reply_content MEDIUMTEXT NOT NULL,
--     reply_like INT DEFAULT 0 NOT NULL,
--     reply_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
--     FOREIGN KEY (reply_boardNo) REFERENCES `board`(board_id),
--     FOREIGN KEY (reply_writer) REFERENCES `user`(user_id)
-- );

-- 찜
-- CREATE TABLE IF NOT EXISTS `bookmark`(
-- 	reply_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
--     reply_boardNo INT NOT NULL,
--     reply_writer VARCHAR(60) NOT NULL,
--     reply_content MEDIUMTEXT NOT NULL,
--     reply_like INT DEFAULT 0 NOT NULL,
--     reply_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
--     FOREIGN KEY (reply_boardNo) REFERENCES `board`(board_id),
--     FOREIGN KEY (reply_writer) REFERENCES `user`(user_id)
-- );


-- 추천 테이블


-- 테스트용 데이터 입력



SELECT * FROM `user`;
SELECT * FROM `board`;
SELECT * FROM `reply`;