package com.example.gym.service.program;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.ProgramDTO;
import com.example.gym.repository.PaymentHistoryRepository;
import com.example.gym.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class ProgramServicelmpl implements ProgramService {

    private final ModelMapper modelMapper;
    private final ProgramRepository programRepository;
    @Override
    public String register(ProgramDTO programDTO) {
        return null;
    }

    @Override
    public ProgramDTO readOne(String programId) {
        return null;
    }

    @Override
    public void modify(ProgramDTO programDTO) {

    }

    @Override
    public void remove(String programId) {

    }
}
