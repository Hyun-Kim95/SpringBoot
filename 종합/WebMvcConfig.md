# WebMvcConfig

* @Configuration
  * 스프링부트 시작할때 여기부터 읽어들임
* @Qualifier("beforeActionInterceptor")
  * Autowired 와 같이 사용해서 명확하게 붙혀줄 객체를 정함
  * beforeActionInterceptor를 객체로 만들어서 붙혀줌

### addInterceptors

* 인터셉터추가
* addPathPatterns("/**")
  * 모든 이동 경로 다 검사

* excludePathPatterns("/resource/**")
  * resource 내부는 검사 안함

