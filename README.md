# Project_GYM
헬스장 웹 페이지 개인프로젝트 포토폴리오

# 소개
 헬스장 과 트레이너 소개 및 회원군 구매 기능 구현 페이지 


# 제작기간 & 참여 인원
<UL>
  <LI>2023.09.20 ~ 2023.010.24</LI>
  <LI>개인 프로젝트</LI>
</UL>

# 사용기술
![js](https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/Java-FF0000?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/IntelliJ-004088?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/security-6DB33F?style=for-the-badge&logo=JavaScript&logoColor=white)

![js](https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white)




# 핵심 기능 및 페이지 소개

<H3>메인 페이지</H3>
<BR>
<img width="800px" src="https://github.com/JeongYoun-24/Project_Gym.github.io/assets/126854252/1f299638-cca8-458a-9019-3d0247219047">


<UL>
 <LI>메인페이지 구현 영상입니다.</LI>
</UL>
<BR>

<details>
 <summary> 메인 페이지 Controller 코드
 
 </summary> 
 

</details>

<details>
 <summary> Service 코드 
 
 </summary> 
 

</details>

<details>
 <summary> Entity및 DTO 코드 
 
 </summary> 
 

</details>

<HR>
<H3>회원권 페이지</H3>
<BR>
<img width="800px" src="https://github.com/JeongYoun-24/Project_Gym.github.io/assets/126854252/4154fe28-0f79-4205-b250-8659ba4de846"> 

<UL>
 <LI>회원권 구매 페이지 입니다.</LI>
</UL>
<BR>

<details>
 <summary> 회원권 Controller 코드
 
 </summary> 
  @GetMapping("/membership") // 회원권 페이지만 보기
    public String gallery(){

        return "Main/pricing";
    }
    @GetMapping("/ship/{shipNo}") // 회원권 상세 페이지
    public String ship(@PathVariable("shipNo")String shipNo, Model model){
        log.info("클라이언트로부터 받은 값 ======"+shipNo);

        Long membershipNo = Long.parseLong(shipNo);

        MembershipDTO membershipDTO =membershipService.readOne(membershipNo);

        log.info("서비스로부터 받은 DTO 값 ====="+membershipDTO );

        model.addAttribute("membershipDTO",membershipDTO);



        return "membership/ship";
    }

    @ResponseBody   // 회원권 결제 ajax 처리
    @RequestMapping(value = "/ship",method = {RequestMethod.POST}, produces="application/json;charset=UTF-8")
    public ResponseEntity Postship(@RequestBody HashMap<String,Object> map,Model model,Principal principal) {

        log.info("클라이언트로부터 받은 값 ======" + map);

        String shipNo = (String) map.get("shipNo");

        Long membershipNo = Long.parseLong(shipNo);

        log.info("받은값 전환 ====" + membershipNo);
       MembershipDTO membershipDTO =  membershipService.readOne(membershipNo);


        if (principal == null) {

            return new ResponseEntity<String>("로그인 필수", HttpStatus.BAD_REQUEST);
        }
      String name = principal.getName();
            log.info(name);
         MemberDTO memberDTO = memberService.readOne(name);
            log.info(memberDTO);


        ShipHistory shipHistory  = shipHistoryRepository.findByMembership_MembershipNo(membershipNo);

        if(shipHistory.getMembership().getMembershipNo() == membershipDTO.getMembershipNo()){

            return new ResponseEntity<String>("결제실패", HttpStatus.BAD_REQUEST);
        }


        try{
            // 결제 내역 저장
            ShipHistoryDTO shipHistoryDTO  =   ShipHistoryDTO.builder()
                    .memberId(memberDTO.getMemberId())
                    .membershipNo(membershipDTO.getMembershipNo())
                    .price(membershipDTO.getPrice())
                    .months(membershipDTO.getMonths())
                    .shipDate(LocalDateTime.now())
                    .build();

          Long shipNo2 = shipHistoryService.register(shipHistoryDTO);

            memberDTO.setMemberShipCheck("on");
            memberService.shipModify(memberDTO);


        }catch (Exception e){
            model.addAttribute("errorMessage","영화 수정 중 에러가 발생했습니다.");
            return new ResponseEntity<String>("결제실패", HttpStatus.BAD_REQUEST);
        }



        return new ResponseEntity<String>("결제완료", HttpStatus.OK);
    }




    @ResponseBody   // 회원권 개월수 확인
    @RequestMapping(value = "/poship",method = {RequestMethod.POST}, produces="application/json;charset=UTF-8")
    public MembershipDTO posterJson(@RequestBody HashMap<String,Object> map, Model model){
        log.info("클라이언트로부터 받은 Ajax =="+map);


        String shipNo = (String) map.get("shipNo");



        Long membershipNo = Long.parseLong(shipNo);

        MembershipDTO membershipDTO =membershipService.readOne(membershipNo);


        return  membershipDTO;
    }




    @GetMapping("/shipRegister") // 회원권 등록 페이지
    public String shipRegister(){



        return "membership/shipRegister";
    }

</details>

<details>
 <summary> Service 코드 
 
 </summary> 
  private final ModelMapper modelMapper;
    private final MembershipRepository membershipRepository;


    @Override
    public Long register(MembershipDTO membershipDTO) {  // 회원권 등록

        Membership membership = modelMapper.map(membershipDTO, Membership.class);

        Long membershipNo = membershipRepository.save(membership).getMembershipNo();


        return membershipNo;
    }

    @Override
    public MembershipDTO readOne(Long membershipNo) { // 아이디값으로 정보 조회 
        Optional<Membership> movie=  membershipRepository.findById(membershipNo);

        MembershipDTO membershipDTO = modelMapper.map(movie, MembershipDTO.class);

        return membershipDTO;
    }

    @Override
    public void modify(MembershipDTO membershipDTO) {

        Optional<Membership> result = membershipRepository.findById(membershipDTO.getMembershipNo());
        Membership movie = result.orElseThrow();

        movie.change(membershipDTO.getPrice(), membershipDTO.getMonths());
        membershipRepository.save(movie);

    }

    @Override
    public void remove(Long membershipNo) {
        membershipRepository.deleteById(membershipNo);
    }
}

</details>

<details>
 <summary> Entity및 DTO 코드 
 </summary>

 
</details>



<H3>트레이너 페이지</H3>
<BR>
<img width="800px" src="https://github.com/JeongYoun-24/Project_Gym.github.io/assets/126854252/e8555690-f901-4898-9399-983a4148e835">

<UL>
 <LI>트레이너 소개 페이지입니다.</LI>
</UL>
<BR>

<details>
 <summary> 트레이너 페이지 Controller 코드
 
 </summary> 
 

</details>

<details>
 <summary> Service 코드 
 
 </summary> 
 

</details>

<details>
 <summary> Entity및 DTO 코드 
 
 </summary> 
 

</details>


<H3>헬스장 사진 페이지</H3>
<BR>
<img width="800px" src="https://github.com/JeongYoun-24/Project_Gym.github.io/assets/126854252/041c6ee9-3d53-4e6d-9a06-804505c682ad">


<UL>
 <LI>헬스장 기구 종류 및 소개 사진입니다.</LI>
</UL>

<HR>

<details>
 <summary> 시큐리티 코드
 
 </summary> 
 
    private final DataSource dataSource;
    private final CustomUserDetailsService customUserDetailsService;


    // 로그인과정 생략 : 개발자 직접 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        log.info("----- configure ------");

        http.formLogin().loginPage("/member/login") //사용자가 설정한 로그인 페이지
                .defaultSuccessUrl("/main")//로그인 성공시 이동 경로
                .usernameParameter("email")//로그인시 사용될 유저 이름
                .failureUrl("/member/login/error")
                .and()//그리고
                .logout() //로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))//로그아웃 경로
                .logoutSuccessUrl("/main"); //로그아웃 성공시 이동 경로

        http.csrf().disable();
        http.formLogin().loginPage("/member/login");

        //인증되지 않은 사용자가 리소스 요청할 경우 에러
        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());// 403 에러 처리

        // 자동 로그인 처리
        http.rememberMe().key("12345678")  // 키값 생성
                .tokenRepository(persistentTokenRepository()) // 토근 생성
                .userDetailsService(customUserDetailsService) // 서큐리티 로그인 정보
                .tokenValiditySeconds(60*60*24*30); // 유효기간 30일



        return http.build();
    }

    // 해시코드로 암호화 처리
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 정적자원(resources -> static)들은 스프링시큐리티 적용에서 제외
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        log.info("--0--0-0-0-0-0-0-");

        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }

    // 접근 권한 거부 예외발생 처리
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){

        return  new Custom403Handler();
    }

    // 자동 로그인 (로그인정보 :UserDatoils외 db유저)
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl repo =new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);

        return  repo;
    }

</details>




# 프로젝트를 통해 느낀 점과 소감


이번 프로젝트는  HTML FREE 사이트를 이용하여 만들었습니다. <BR>
SPRING BOOT를 통해 만들었으며 MARIADB를 이용하여 데이터베이스를 저장했습니다.<BR>
jar 파일로 만들어  AWS EC2 인스턴스를 통해 서버 연결도 해보왔습니다.
하지만 아직 미숙하여 조금더 프로젝트를 만들어봐야 할것같다고 생각했습니다.
이제는 안드로이드도 만들어 볼생각입니다.

