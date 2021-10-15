# ArticleDao

* 데이터 관련 작업
* 서비스의 요청을 처리
* 앞에 public 붙혀줘야 함

### getArticle

* 인자로 id가 전달되면 그 id와 일치하는 값을 찾음

### getArticles

* 인자로 searchKeywordType, searchKeyword 가 오면 검색할 타입에서 키워드를 찾아서 일치하는 값들 리턴
  * searchKeywordType은 title 과 body 중에서 고를 수 있음
  * 입력 값이 둘다 아니면 두군데 모두에서 찾음
* 인자가 없으면 전체를 리스트에 담아서 리턴

### addArticle

* 컨트롤러에서 id 존재여부만 확인하고 전달해주면 articles에 추가

### deleteArticle

* id를 받아 삭제 진행
* 성공여부에 따라서 true or false 리턴

### modifyArticle

* id를 찾아서 title,body 수정

# XML

* WHERE 1
  * 항상 true
* useGeneratedKeys="true" keyProperty="id"
  * id를 autoincrement로 적용시킴

* if문 사용 가능
  * <if test="searchKeywordType == 'title'"\>
    			AND title LIKE CONCAT('%',#{searchKeyword}, '%')
      		</if\>

* LIKE문을 사용하려면 CONCAT 이용해야함
  * AND title LIKE CONCAT('%',#{searchKeyword}, '%')

* SET 부분은 <set\> 으로 감싸주는게 관례임(SET안쓰고)
  * set 안쪽에 if문이 다 안돌면 오류가 날 수도 있기 때문에 사용

* getForPrintArticle
  * 닉네임까지 보이게 출력
* getForPrintArticles
  * 원래 getArticles에 getForPrintArticle 을 합쳐서 만듬
  * 마지막줄에 if문을 이용해서 페이지번호(limitStart), 한 페이지에 보여줄 갯수(limitTake) 추가 코딩