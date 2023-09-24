package com.example.gym.service.member;

import com.example.gym.dto.MemberDTO;
import com.example.gym.entity.Member;

public interface MemberService {

    public String register(MemberDTO memberDTO); // 회원가입 메서드
    public MemberDTO readOne(String memberId);   // 회원 정보 조회 메서드
    public void modify(MemberDTO memberDTO);    // 회원 정보 수정
    public void remove(String memberId);      // 회원정보 삭제 (탈퇴)


    public MemberDTO login(String name , String email);
    public MemberDTO loginId(String email);    // 로그인

    public MemberDTO loginPwd(String userid,String email); // 로그인 비밀번호 찾기

    public void pwdUpdate(MemberDTO usersDTO);     // 로그인 비밀번호 변경


    public Member saveMember (Member member);    // 회원정보 저장

}
