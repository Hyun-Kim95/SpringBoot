# MySQL

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