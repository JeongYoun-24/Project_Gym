package com.example.gym.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Table(name="program")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Program {  // 프로그램 종료
    
    @Id
    @Column(name = "")
    private String programId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Teacher teacher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    private int inRegistrant;
    private int outRegistrant;
    private Date programDate;
    
    
    
    
}
