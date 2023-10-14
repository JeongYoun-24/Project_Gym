package com.example.gym.dto;

import com.example.gym.entity.Rank;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RankDTO {


    private Long rankNo;  // 직급 번호
    // @NotBlank(message = "월급은 필수 입력값입니다.")
    private int salary;   // 월급
   // @NotBlank(message = "강의비용은 필수 입력값입니다.")
    private int lectureFee; // 강의비용


    private static ModelMapper modelMapper = new ModelMapper();
    public static RankDTO of (Rank rank){
        return modelMapper.map(rank, RankDTO.class);
    }
    // DTO -> entity
    public Rank createBoard(){
        return modelMapper.map(this, Rank.class);
    }

}
