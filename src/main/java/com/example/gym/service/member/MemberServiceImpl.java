package com.example.gym.service.member;

import com.example.gym.dto.MemberDTO;
import com.example.gym.entity.Member;
import com.example.gym.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{


    private final ModelMapper modelMapper;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public Member saveMember(Member member){
        // 서버에서 validate적용
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member users){
        Member findMember = memberRepository.findByEmail(users.getEmail());
        Member findMember2 = memberRepository.findByNameOrEmail(users.getName() ,users.getEmail());

        // 이미 가입된 회원인 경우 예외 발생
        if (findMember2 != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }

    }

    @Override
    public String register(MemberDTO memberDTO) {
        // dto-> entity로 데이터 복사
        Member member = modelMapper.map(memberDTO,Member.class);
        String membmerId = memberRepository.save(member).getMemberId();

        return membmerId;
    }

    @Override
    public MemberDTO readOne(String membmerId) {
        Member member = memberRepository.findById(membmerId).orElseThrow(EntityNotFoundException::new);

        MemberDTO usersDTO = modelMapper.map(member,MemberDTO.class);

        return usersDTO;
    }

    @Override
    public void modify(MemberDTO memberDTO) {

        Member member = memberRepository.findById(memberDTO.getMemberId()).orElseThrow(EntityNotFoundException::new);


        member.change(memberDTO.getPassword(),memberDTO.getName(),memberDTO.getEmail());
        memberRepository.save(member);

    }





    @Override
    public void remove(String membmerId) {
        memberRepository.deleteById(membmerId);
    }

    @Override
    public MemberDTO login(String name, String email) {
        Member member = memberRepository.findByNameOrEmail(name,email);

        MemberDTO memberDTO = modelMapper.map(member,MemberDTO.class);

        return memberDTO;
    }

    @Override
    public MemberDTO loginId(String email) {

        Member member = memberRepository.findByEmail(email);

        MemberDTO memberDTO = modelMapper.map(member,MemberDTO.class);

        return memberDTO;
    }

    @Override
    public MemberDTO loginPwd(String memberId, String email) {
        Member member= memberRepository.findByMemberIdOrEmail(memberId,email);

        MemberDTO memberDTO = modelMapper.map(memberId,MemberDTO.class);

        return memberDTO;
    }

    @Override
    public void pwdUpdate(MemberDTO memberDTO) {

        Member member =  memberRepository.findById(memberDTO.getMemberId()).orElseThrow(EntityNotFoundException::new);


        member.pwdUpdate(memberDTO.getPassword(),passwordEncoder);
        memberRepository.save(member);


    }



}
