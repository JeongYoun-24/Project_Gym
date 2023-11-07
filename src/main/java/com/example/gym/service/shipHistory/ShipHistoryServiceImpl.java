package com.example.gym.service.shipHistory;

import com.example.gym.dto.ShipHistoryDTO;
import com.example.gym.entity.Member;
import com.example.gym.entity.Membership;
import com.example.gym.entity.MembershipPayment;
import com.example.gym.entity.ShipHistory;
import com.example.gym.repository.MemberRepository;
import com.example.gym.repository.MembershipRepository;
import com.example.gym.repository.ShipHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Locale;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class ShipHistoryServiceImpl implements ShipHistoryService{

    private final ModelMapper modelMapper;

    private final ShipHistoryRepository shipHistoryRepository;
    private final MemberRepository memberRepository;
    private final MembershipRepository membershipRepository;

    @Override
    public Long register(ShipHistoryDTO shipHistoryDTO) {
      Member member=  memberRepository.findById(shipHistoryDTO.getMemberId()).orElseThrow(RuntimeException::new);
        Membership membership = membershipRepository.findById(shipHistoryDTO.getShipNo()).orElseThrow(RuntimeException::new);
        log.info("값 전달 받는지 테스트 ");
        ShipHistory shipHistory = ShipHistory.builder()
                .shipNo(shipHistoryDTO.getShipNo())
                .price(shipHistoryDTO.getPrice())
                .months(shipHistoryDTO.getMonths())
                .shipDate(LocalDateTime.now())
                .member(member)
                .membership(membership)
                .build();


        log.info("값 전달 받는지 테스트2 "+shipHistory);
        ShipHistory shipHistory1 = shipHistoryRepository.save(shipHistory);
        log.info("값 전달 받는지 테스트3 "+shipHistory1);
        return shipHistory1.getShipNo();
    }

    @Override
    public ShipHistoryDTO readOne(Long shipNo) {



        return null;
    }

    @Override
    public void modify(ShipHistoryDTO shipHistoryDTO) {

    }

    @Override
    public void remove(Long shipNo) {

    }
}
