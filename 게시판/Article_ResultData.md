# Article

* dto 패키지에 만듬

* toString
  * 객체를 sysout 등으로 출력할 때, 주소가 아니라 깔끔하게 출력되도록 함
  
* Lombok 적용

  * 게터,세터,생성자, toString 알아서 작성해줌

  * 프로젝트 우클릭 -> Spring -> Add Starters

  * Lombok 체크 -> Next

  * pom.xml 체크 -> finish

  * 후에 Lombok 패치 해줘야됨(이클립스 종료하고)

  * C:\Users\User\.m2\repository\org\projectlombok\lombok\1.18.20 에서 lombok-1.18.20.jar 더블클릭

  * Specify location 클릭

  * SpringToolsSuite4.exe 있는 곳까지 가서 클릭하고 select  후 Install 클릭 후 Quit Installer 클릭

  * C:\work\sts-4.12.0.RELEASE 들어가 보면 lombok.jar 생겼음

  * 혹시 실행이 안되면 SpringToolSuite4.ini 들어가서

  * -vm

    plugins/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_16.0.2.v20210721-1149/jre/bin

    얘가 두번 적혀 있으면 하나 삭제, 그래도 안되면

  * -javaagent:C:\work\sts-4.12.0.RELEASE\lombok.jar -> -javaagent:lombok.jar 변경

  * 이클립스 키고 Article 위에 @Data 추가(게터,세터,toString 생성), 그 밑에 @AllArgsConstructor 추가(생성자 생성)

    * @NoArgsConstructor(인자 없는 생성자 생성)

  * Window -> Show View -> Outline 클릭해보면 게터, 세터, toString 등 돼있는 것 확인 가능

# ResultData

* 함수 실행의 결과에 대한 출력 함수
* Lombok 설정(@Data)
* 생성자로 결과코드(S or F), msg, 기타등등(갯수 상관없음)
