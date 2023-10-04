package com.example.gym.service.member;

import com.example.gym.dto.MemberDTO;
import com.example.gym.entity.Member;

public interface MemberService {

    public String register(MemberDTO memberDTO);
    public MemberDTO readOne(String memberId);
    public void modify(MemberDTO memberDTO);
    public void remove(String memberId);


    public MemberDTO login(String name , String email);
    public MemberDTO loginId(String email);

    public MemberDTO loginPwd(String memberId,String email);

    public void pwdUpdate(MemberDTO usersDTO);


    public Member saveUsers (Member member);


//    public UsersDTO findByLoginId(String user_id,String user_pwd);
//
//    public List<Users> allList(); // 전체 리스트

//    public UsersDTO loginId(String user_email); // 이메일정보로 아이디 찾기
//    public UsersDTO loginPwd(String user_id,String user_email); // 아이디 이메일정보로 비밀번호 찾기

}
