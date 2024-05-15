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
    -- 최대 5글자, 소수점 아래 2자리까지
    user_goalWeight DOUBLE(5, 2),
    user_nowWeight DOUBLE(5, 2)
);

CREATE TABLE IF NOT EXISTS `board`(
	board_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    board_boardType TINYINT NOT NULL,
    board_title VARCHAR(255) NOT NULL,
    board_content MEDIUMTEXT DEFAULT ' ' NOT NULL,
    board_writer VARCHAR(60) NOT NULL,
    board_like INT DEFAULT 0 NOT NULL,
    board_hate INT DEFAULT 0 NOT NULL,
    board_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    board_viewCnt INT DEFAULT 0 NOT NULL,
    -- 일단은 작성자가 아이디를 참조하도록 함
    -- writer가 무엇을 참조할 지 결정 후 수정
    FOREIGN KEY (board_writer) REFERENCES `user`(user_id)
);

CREATE TABLE IF NOT EXISTS `reply`(
	reply_id INT PRIMARY KEY NOT NULL,
    reply_boardNo INT AUTO_INCREMENT NOT NULL,
    reply_writer VARCHAR(60) NOT NULL,
    reply_content MEDIUMTEXT DEFAULT ' ' NOT NULL,
    reply_like INT DEFAULT 0 NOT NULL,
    reply_regDate DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (reply_id) REFERENCES `board`(board_id),
    FOREIGN KEY (reply_writer) REFERENCES `user`(user_id)
);