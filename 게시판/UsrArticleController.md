# UsrArticleController

* 안내데스크역할
* 요청을 최소한의 검증을 하고 서비스로 요청함
  * Dao의 존재도 모르는 애

### showDetail

* 쿼리스트링으로 ?id=1 과 같이 주소에 전달하면 화면에 띄워줌

### showList

* 전체 리스트를 보여줌
* 검색기능 추가
  * searchKeywordType 검색할 타입
    * 지정안하면 titleAndBody 가 기본값
  * searchKeyword 검색할 내용
    * 값이 ?searchKeyword= 까지만 들어오면 공백으로 들어오므로 null로 바꿔줌
    * 좌우 공백은 제거해야 하므로 null이 아닐때, trim() 붙혀줌
* 페이징 기능 추가
  * @RequestParam(defaultValue="1")int page
    * 값이 안들어오면 디폴트 값 1
  * itemsInAPage
    * 한 페이지에 보여줄 리스트의 갯수

### doAdd

* title, body를 쿼리스트링으로 전달하면 리스트에 추가해줌
* Map을 사용한 이유
  * 성공이나 실패했을 시에 보여줘야 할 정보들이 하나가 아니라서
    * 실패이유, 몇번째 id인지 등등
* 세션을 이용해서 로그인됐으면 id정보도 param에 추가

### doDelete

* id를 입력하면 foreach문으로 돌리다가 같은 id가 있으면 제거 후 true 리턴,

  없으면 false 리턴하는 함수를 따로 만들어서 호출( deleteArticle(int id) )

* 2번이 마지막 id일 때, 2번 id를 삭제 후 리스트를 추가하면 3번부터 추가됨

* id와 memberId가 같은지, 로그인했는지, 1번 회원(관리자) 인지 확인을 위해 서비스호출

### doModify

* id 찾아서 제목과 내용 수정
* updateDate 수정됨(Util.getNowDateStr())
* id와 memberId가 같은지, 로그인했는지, 1번 회원(관리자) 인지 확인을 위해 서비스호출

