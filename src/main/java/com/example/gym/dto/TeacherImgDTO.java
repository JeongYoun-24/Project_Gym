package com.example.gym.dto;

import com.example.gym.entity.Teacher;

import javax.persistence.*;

public class TeacherImgDTO {


    private Long id;
    private String imgName;// 이미지 파일명
    private String oriImgName;// 원본 이미지 파일명
    private String imgUrl;// 이미지 조회 경로
    private String repImgYn; // 대표 이미지 여부
    private String employeeId;



}
