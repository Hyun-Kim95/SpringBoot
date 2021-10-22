# login.jsp

### input

* autofocus : 자동으로 포커스가 이동
* placeholder : 박스 안에 글씨 입력 가능

### tailwind

* cdnjs.com에 들어가서 tailwind검색해서 tailwindcss 클릭 후 맨 위에 나오는 주소 복사해서 사용
  * <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.17/tailwind.min.css" />
* "flex" : 가로로 나오게 함
* "container mx-auto" : 중앙에 맞춤
* "bg-black" : 배경을 검정으로
* "w-full" : 너비 풀로
* "p-1" : 패딩을 1로
* "mb-4" : 마진 바텀 4
* "flex-grow" : 크기 맞춰서 변함
* "md:" : 미디엄 디바이스일때, 변할 것 적음
* "flex-col", "flex-low" : 새로, 가로로 정렬함
* "md:flex md:items-center" : 미디엄 디바이스일 때, 가운데 정렬
* "min-h-screen" : 최소 높이를 설정
* "h-screen" : 화면 높이
  * "h-full flex items-center justify-center" : 위의 높이 받아오고, 높이 중앙되고, 완전 가운데 맞춤
  * 세트로 사용함
* "shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
  * 그림자, 테두리둥글게, 가로채우기, 패딩 위아래, 패딩 좌우, 텍스트 색상
* text-xl : 텍스트 조금 키움
* hover:underline
  * 마우스 올리면 밑줄 생김
* 이 외의 사용법은 tailwind documentation에 검색하면 알 수 있음

### script

* onsubmit="LoginForm__checkAndSubmit; return false;"
  * submit 을 눌렀을 때 실행할 스크립트 이름
  * return false가 submit 버튼을 눌러도 전송이 안됨

* Help -> Install new Software 에서 Work with에 Latest 선택
  * 맨 밑의 Web, XML 부분의 Java Script 로 시작하는 2개 체크 및 설치
* form.submit(); 을 통해서만 다음으로 넘어갈 수 있음

* const LoginForm__checkAndSubmitDone = false;
  * submit 전송을 한번 했으면 true로 바꿔서 또 전송되지 않도록 하려고 만듬

