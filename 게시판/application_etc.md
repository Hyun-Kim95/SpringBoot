# application.yml

```
server:
  port: 8021	# 띄어쓰기 2개 + 원하는 포트로 설정
spring:			# DB 연결할 때 적어줌
  datasource:
    # 쿼리문 실행되면 콘솔에 보여줌
    driver-class-name: net.sf.log4jdbc.sql.jdbcapi.DriverSpy
#    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:log4jdbc:mysql://127.0.0.1:8086/untact?# 이 부분만 맞게 적고 나머지는 복붙    useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull
    username: boardUser
    password: 1234
mybatis:
  type-aliases-package: com.untact.dto
  # 이거 적어주면 ArticleDao.xml에서 resultType에 풀 경로 적어주지 않아도 됨
```

* 로거사용 시 추가 설정
  * <!-- SQL 로거 -->
    		<dependency>
      			<groupId>org.bgee.log4jdbc-log4j2</groupId>
      			<artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
      			<version>1.16</version>
      		</dependency>
  * resources 폴더에 파일 추가
    * log4jdbc.log4j2.properties
    * logback.xml
    * 필요할 때 복붙으로 사용하면 됨

* 실행하면 LOG_PATH_IS_UNDEFINED 폴더가 자동으로 생성됨
  * 로그랑 오류 모아놓는 폴더임