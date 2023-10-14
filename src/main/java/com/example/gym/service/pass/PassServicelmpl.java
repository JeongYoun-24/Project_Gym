package com.example.gym.service.pass;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.PassDTO;
import com.example.gym.repository.MembershipRepository;
import com.example.gym.repository.PassRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class PassServicelmpl implements PassService {

    private final ModelMapper modelMapper;
    private final PassRepository passRepository;
    @Override
    public String register(PassDTO passDTO) {
        return null;
    }

    @Override
    public PassDTO readOne(Long passNo) {
        return null;
    }

    @Override
    public void modify(PassDTO passDTO) {

    }

    @Override
    public void remove(Long passNo) {

    }
}
