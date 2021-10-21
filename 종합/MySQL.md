# MySQL

### 데이터베이스 생성

DROP DATABASE IF EXISTS untact;
CREATE DATABASE untact;
USE untact;

### 게시물 테이블 생성

CREATE TABLE article(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL
);

### 테스트 데이터 생성

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = "제목1 입니다.",
`body` = "내용1 입니다.";

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = "제목2 입니다.",
`body` = "내용2 입니다.";

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = "제목3 입니다.",
`body` = "내용3 입니다.";

### 회원 테이블 생성

CREATE TABLE `member`(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(30) NOT NULL,
	loginPw VARCHAR(100) NOT NULL,
	`name` CHAR(30) NOT NULL,
	`nickname` CHAR(30) NOT NULL,
	`cellphoneNo` CHAR(20) NOT NULL,
	`email` CHAR(100) NOT NULL
);

##### untact 클릭한 상태로 F5 -> member클릭한 상태로 F6 -> 인덱스 클릭 -> `id`asc 밑에 클릭해서 `loginId` 선택 -> 인덱스 종류를 UNIQUE로 설정(같은 아이디 사용불가, 로그인 아이디로 검색시 속도향상)
### 로그인 ID로 검색했을 때
ALTER TABLE `member` ADD UNIQUE INDEX (`loginId`);

### 회원, 테스트 데이터 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = "user1",
loginPw = "user1",
`name` = "user1",
nickname = "user1",
cellphoneNo = "01012341234",
email = "jangka512@gmail.com";

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = "user2",
loginPw = "user2",
`name` = "user2",
nickname = "user2",
cellphoneNo = "01012341234",
email = "jangka500@gmail.com";

### 게시물 테이블에 회원번호 칼럼 추가

ALTER TABLE article ADD COLUMN memberId INT(10) UNSIGNED NOT NULL AFTER updateDate;

### 기존 게시물의 작성자를 회원 1로 지정

UPDATE article
SET memberId = 1
WHERE memberId = 0;

### 테스트 게시물 추가

INSERT INTO article
(regDate, updateDate, memberId, title, `body`)
SELECT NOW(), NOW(), FLOOR(RAND()*2)+1, CONCAT('제목_', FLOOR(RAND()*1000)+1), CONCAT('내용_', FLOOR(RAND()*1000)+1)
FROM article;									# 전체 개수만큼 늘어남

SELECT COUNT(*) FROM article;	# 몇개 만들었는지 보려고

### 게시판별 리스팅
CREATE TABLE board(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	`code` CHAR(20) UNIQUE NOT NULL,
	`name` CHAR(20) UNIQUE NOT NULL
);

### 공지사항 게시판 추가
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'notice',
`name` = '공지사항';

### 자유게시판 추가
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'free',
`name` = '자유';

### boardId를 article테이블에 추가
ALTER TABLE article ADD COLUMN boardId INT(10) UNSIGNED NOT NULL AFTER updateDate;

### 빈 boardId 채우기
UPDATE article
SET boardId = FLOOR(RAND() * 2) + 1
WHERE boardId = 0;

### 댓글 테이블 추가
CREATE TABLE reply(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	articleId INT(10) UNSIGNED NOT NULL,
	memberId INT(10) UNSIGNED NOT NULL,
	`body` TEXT NOT NULL
);

### 테스트데이터

INSERT INTO reply
SET regDate = NOW(),
updateDate = NOW(),
articleId = 1,
memberId = 1,
`body` = "내용1 입니다.";

INSERT INTO reply
SET regDate = NOW(),
updateDate = NOW(),
articleId = 1,
memberId = 2,
`body` = "내용2 입니다.";

INSERT INTO reply
SET regDate = NOW(),
updateDate = NOW(),
articleId = 2,
memberId = 2,
`body` = "내용3 입니다.";

### 게시물 전용 댓글에서 범용 댓글로 바꾸기 위해 relTypeCode 추가

ALTER TABLE reply ADD COLUMN `relTypeCode` CHAR(20) NOT NULL AFTER updateDate;

### 현재는 게시물 댓글 밖에 없기 때문에 모든 행의 relTypeCode 값을 article로 지정

UPDATE reply
SET relTypeCode = 'article'
WHERE relTypeCode = '';

### articleId 칼럼명을 relId로 수정

ALTER TABLE reply CHANGE `articleId` `relId` INT(10) UNSIGNED NOT NULL;

### 고속 검색을 위해서 인덱스 걸기

ALTER TABLE reply ADD KEY (relTypeCode , relId);
SELECT * FROM reply;

### authKey 칼럼을 추가
ALTER TABLE `member` ADD COLUMN authKey CHAR(80) NOT NULL AFTER loginPw;

### 기존 회원의 authKey 데이터 채우기
UPDATE `member`
SET authKey = 'authKey1__39285f22-3157-11ec-805d-2cf05da835df__0.9446445982387704'
WHERE id=1;

UPDATE `member`
SET authKey = 'authKey1__39286ba6-3157-11ec-805d-2cf05da835df__0.2614991490370586'
WHERE id=2;

UPDATE `member`
SET authKey = 'authKey1__40cc142a-315a-11ec-805d-2cf05da835df__0.23235432825270513'
WHERE id=3;

### authKey 칼럼에 유니크 인덱스 추가
ALTER TABLE `member` ADD UNIQUE INDEX (`authKey`);

SELECT * FROM `member`;
