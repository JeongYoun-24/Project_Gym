package com.example.gym.service.paymentHistory;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.PaymentHistoryDTO;
import com.example.gym.repository.PassRepository;
import com.example.gym.repository.PaymentHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class PaymentHistoryServicelmpl implements PaymentHistoryService {

    private final ModelMapper modelMapper;
    private final PaymentHistoryRepository paymentHistoryRepository;
    @Override
    public String register(PaymentHistoryDTO paymentHistoryDTO) {
        return null;
    }

    @Override
    public PaymentHistoryDTO readOne(Long historyId) {
        return null;
    }

    @Override
    public void modify(PaymentHistoryDTO paymentHistoryDTO) {

    }

    @Override
    public void remove(Long historyId) {

    }
}
