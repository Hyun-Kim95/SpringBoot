# UsrMemberController

### doJoin(@RequestParam Map<String, Object> param)

* 최소 인자갯수 확인 후, 필요한 정보가 다 있으면 Service의 join에 param 전달, 부족하면 메세지 리턴

*  getMemberByLoginId
  * 이미 사용중인 로그인 아이디라면 메세지 출력

### doLogin(String loginId, String loginPw, HttpSession session)

* HttpSession session
  * 이거 적으면 알아서 세션에 저장됨
    * 쿠키,세션,캐쉬 관련해서는 '얄팍한 코딩사전' 보기
  * 단순하게 저장할 수록 좋음(id 로 저장함)
    * session.setAttribute("loginedMemberId", existingMember.getId());

### doLogout(HttpSession session)

* 세션으로 로그인 상태인지 확인 후 로그아웃

### doModify(@RequestParam Map<String, Object> param, HttpSession session)

* 세션은 로그인 정보 확인용
  * 로그인 후에 수정해야해서
* param이 비었으면 메세지 리턴
* param에 id값도 추가해서 서비스로 넘김



