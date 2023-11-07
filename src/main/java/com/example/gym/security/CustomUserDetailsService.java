package com.example.gym.security;

import com.example.gym.entity.Member;
import com.example.gym.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
//@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private final MemberRepository memberRepository;
//    private final UsersRepository usersRepository;

//    private  PasswordEncoder passwordEncoder;
//    public   CustomUserDetailsService(){
//        this.passwordEncoder = new BCryptPasswordEncoder();
//
//    }



    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
//        Users users = memberRepository.findByEmail(Email);
        Member member = memberRepository.findByMemberId(memberId);

        if(member == null){  //회원 정보가 없다
            throw new UsernameNotFoundException(memberId);
        }

        //db로 회원 정보
        return User.builder()

                .username(member.getMemberId())
                .password(member.getPassword())
                .roles(member.getRole().toString())
//                .authorities("ROLE"+member.getRole().toString())
                .build();
    }








}
