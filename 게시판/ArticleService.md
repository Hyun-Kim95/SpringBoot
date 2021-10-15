# ArticleService

* 실제 기능들 하는 곳
* 컨트롤러의 요청 처리

### getArticle

* 인자로 id가 전달되면 Dao로 전달

### getArticles

* Dao로 전달

### addArticle

* 컨트롤러에서 id 존재여부만 확인하고 전달해주면 Dao로 전달

### deleteArticle

* 컨트롤러에서 id 존재여부만 확인하고 전달해주면 Dao로 전달

### modifyArticle

* 컨트롤러에서 id 존재여부만 확인하고 전달해주면 Dao로 전달

### getActorCanModifyRd

* 로그인한 회원이 수정 가능한 게시물인지 확인

### getActorCanDeleteRd

* 로그인한 회원이 삭제 가능한 게시물인지 확인
  * 수정가능한지 확인하는애랑 같은 알고리즘이라서 위에꺼 사용함

### getForPrintArticle

* articleDao의 수정된 쿼리 진행시켜줌

### getForPrintArticles

* articleDao의 수정된 쿼리 진행시켜줌
* 페이징을 위해서 limitStart, limitTake 정의 밑 인자값 추가

