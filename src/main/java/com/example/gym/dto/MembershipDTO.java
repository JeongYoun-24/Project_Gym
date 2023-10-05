package com.example.gym.dto;

import com.example.gym.entity.Membership;
import lombok.*;
import org.modelmapper.ModelMapper;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MembershipDTO {

    private Long membershipNo;  // 회원권 번호
    private int months;         // 개월수
    private int price;          // 금액

    private static ModelMapper modelMapper = new ModelMapper();
    public static MembershipDTO of(Membership membership){
        // entity -> dto
        return modelMapper.map(membership, MembershipDTO.class);
    }
}
