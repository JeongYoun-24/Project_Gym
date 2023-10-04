package com.example.gym.service.member;

import com.example.gym.entity.Member;
import com.example.gym.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {


    private final MemberRepository memberRepository;



    public Member saveUsers(Member member){
        // 서버에서 validate적용
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
//        Users findMember = usersRepository.findByEmail(users.getEmail());
        Member findMember = memberRepository.findByMemberId(member.getMemberId());

        // 이미 가입된 회원인 경우 예외 발생
        if (findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }

    }



}
