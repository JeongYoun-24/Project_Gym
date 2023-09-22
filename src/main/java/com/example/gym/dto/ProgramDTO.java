package com.example.gym.dto;

import com.example.gym.entity.Member;
import com.example.gym.entity.Teacher;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ProgramDTO {


    private String programId;
    private String employeeId;
    private String memberId;
    private int inRegistrant;
    private int outRegistrant;
    private Date programDate;

}
