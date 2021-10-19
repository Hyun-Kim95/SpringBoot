# 순서

## 게시물 작성

* 로그인 필요

### UsrArticleController

* doAdd 에 session 추가해서 로그인 됐는지 확인 후 memberId를 param에 추가

### ArticleDao.xml

* addArticle 부분에 memberId 추가

### Atricle

* memberId 추가

### SQLyog

* article 테이블에 memberId 추가
* 기존 게시물의 작성자를 1로 지정

## 1번 회원을 관리자로 지정

* 게시판관련 함수들마다 로그인정보, 작성자와 같은지, 1번 회원인지 확인해서 가능한지 확인

## 상세페이지에 작성자의 닉네임까지 노출

* UsrArticleController의 detail 부분의 getArticle -> getForPrintArticle 변경
* ArticleService에 getForPrintArticle 생성
* ArticleDao 에 함수선언 및 @Param("id") 붙히기
* ArticleDao.xml 에 작성(left join, ifnull 사용)
  * 탈퇴한 회원이어도 결과값+"탈퇴 회원이라 나오도록"
* Article에 extra__writer 추가

### 게시물리스트에서 작성자명 표시

* UsrArticleController의 list 부분 리턴값을 getArticle -> getForPrintArticle 변경 후 오류수정으로 이어나가서 ArticleDao.xml까지 작성

### 인터셉터 추가

* 중요함★

* 인터셉터 패키지에 BeforeActionInterceptor 생성(복붙 및 수정)

### config 패키지에 WebMvcConfig 생성

* 복붙 및 수정

### resources의 static폴더 안에 resource 폴더 생성

* 상위폴더인 resources와 상관없음
* 이 안의 파일들은 인터셉터가 검사안함

### 인터셉터 추가

* NeedLoginInterceptor, NeedLogoutInterceptor 추가(복붙 및 수정)
* 로그인 로그아웃 빼고는 (HttpSession -> HttpServletRequest)로 변경

### 로그인 후 이용해주세요 같은거 다 삭제

* 인터셉터가 역할을 수행함
* UsrArticleController, UsrMemberController

### 페이징을 위한 테스트 게시물 데이터 추가

* 192개 만들고 코드 주석처리함

### 페이징

* ArticleDao.xml 의 getForPrintArticles 밑에 코드추가
* ArticleService 의 getForPrintArticles 수정
* UsrArticleController의 showList 수정
* ArticleService 의 getForPrintArticles 추가 수정

### 게시판 별 리스팅

* 공지사항, 자유게시판
* mysql쿼리문 작성(board 생성)

* UsrArticleController 의 showList 부터 service, dao 수정

### 댓글 추가

* doAddReply 작성(UsrArticleController)
* 오류수정으로 addReply 생성(ArticleService, ArticleDao)

* sql로 reply 테이블과 테스트 데이터 삽입

* WebMvcConfig에 리스트댓글(replies)도 로그인 없이 볼 수 있게 수정

### 댓글을 범용으로 변경

* UsrReplyController 생성 및 수정(UsrArticleController 복사)
* 테이블 변경(+인덱스 생성)

* 나머지 코드 수정 후, Reply, ReplyService, ReplyDao 생성 및 코드작성

### 댓글 삭제

* UsrArticleController 에서 doDelete 부분 복사해서 UsrReplyController에서 수정

* ReplyService에 복사해서 getActorCanDeleteRd 생성
* ReplyDao에 복사해서 deleteReply 생성

### 댓글 수정

* UsrArticleController에서 doModify 복사해서 UsrReplyController에서 수정
* ReplyService에 getActorCanModifyRd 작성(getActorCanDeleteRd 호출해서 사용)
* ArticleService 에서 수정부분 복사해서 ReplyService에서 수정
* Dao생성

### 포스트맨 준비

* 주소입력 편하게 해주는 툴
* 준비.md 파일에 정리해놓았음

### 관리자 컨트롤러 추가

* 컨트롤러 패키지의 전부를 복사해서 Usr부분을 Adm으로 변경

* Adm들만 다중선택해서 Ctrl + h -> File Search의 Containing text 에 @RequestMapping("/usr/ 를 적고
* Case sensitive랑 Scope 부분의 4 selected resources ~ 부분 체크 후 Replace 클릭
* 위의 usr 부분을 adm으로 변경하고 OK

* WebMvcConfig 에서 needLoginInterceptor 복사해서 needAdminInterceptor 생성

* interceptor 패키지에서 NeedLoginInterceptor 복사해서 NeedAdminInterceptor 만듬
* WebMvcConfig에 어드민 관련 추가(로그인 확인하는 부분에 adm으로 가는 애들 검사 안하도록 추가 등)

* AdmMemberController 에서 doLogin 부분에 isAdmin 추가
* 포스트맨에 추가
