package com.example.gym.service.membershipPayment;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.MembershipPaymentDTO;
import com.example.gym.entity.Membership;
import com.example.gym.entity.MembershipPayment;
import com.example.gym.repository.MembershipPaymentRepository;
import com.example.gym.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class MembershipPaymentServiceImpl implements MembershipPaymentService {

    private final ModelMapper modelMapper;
    private final MembershipPaymentRepository membershipPaymentRepository;

    @Override
    public Long register(MembershipPaymentDTO membershipPaymentDTO) {
        MembershipPayment membershipPayment = modelMapper.map(membershipPaymentDTO, MembershipPayment.class);

        Long membershipNo = membershipPaymentRepository.save(membershipPayment).getPaymentNo();

        return membershipNo;
    }

    @Override
    public MembershipPaymentDTO readOne(Long paymentNo) {
        Optional<MembershipPayment> membershipPayment=  membershipPaymentRepository.findById(paymentNo);

        MembershipPaymentDTO membershipPaymentDTO = modelMapper.map(membershipPayment, MembershipPaymentDTO.class);

        return membershipPaymentDTO;
    }

    @Override
    public void modify(MembershipPaymentDTO membershipPaymentDTO) {
        Optional<MembershipPayment> result = membershipPaymentRepository.findById(membershipPaymentDTO.getPaymentNo());
        MembershipPayment membershipPayment = result.orElseThrow();

       // membershipPayment.change(membershipPaymentDTO.getPrice(), membershipPaymentDTO.getMonths());
       // membershipPaymentRepository.save(membershipPayment);
    }

    @Override
    public void remove(Long paymentNo) {

    }
}
