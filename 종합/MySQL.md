# MySQL

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