package com.example.gym.security;


import com.example.gym.entity.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class CustomUsers extends User {
    private final String Userid;
    private final String password;
    private final String phone;

    // member.getEmail()이 User객체에서 Id역할: User의 Id는 유일성을 보장하는 필드이여함.
    public CustomUsers(Member member, List<GrantedAuthority> authorities) {
        super(member.getMemberId(), member.getPassword(), authorities);

        //User객체가 가지는 username과 password 이외에 id,getAddress,password 추가.
        this.Userid = member.getMemberId();
        this.password = member.getPassword();
        this.phone = member.getPhone();
    }
}
