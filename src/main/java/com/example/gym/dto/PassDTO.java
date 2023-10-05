package com.example.gym.dto;

import com.example.gym.entity.Member;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PassDTO {


    private Long passNo;                  // 출입부 번호
    private String memberId;  // 폴딩키 (회원 아이디 )
    private LocalDateTime inDate;  // 출입날짜
    private LocalDateTime outDate;  // 퇴장 날짜

}
