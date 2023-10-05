package com.example.gym.service.membership;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.entity.Membership;
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
public class MembershipServicelmpl implements MembershipService {


    private final ModelMapper modelMapper;
    private final MembershipRepository membershipRepository;


    @Override
    public Long register(MembershipDTO membershipDTO) {  // 회원권 등록

        Membership membership = modelMapper.map(membershipDTO, Membership.class);

        Long membershipNo = membershipRepository.save(membership).getMembershipNo();


        return membershipNo;
    }

    @Override
    public MembershipDTO readOne(Long membershipNo) { // 아이디값으로 정보 조회 
        Optional<Membership> movie=  membershipRepository.findById(membershipNo);

        MembershipDTO membershipDTO = modelMapper.map(movie, MembershipDTO.class);

        return membershipDTO;
    }

    @Override
    public void modify(MembershipDTO membershipDTO) {

        Optional<Membership> result = membershipRepository.findById(membershipDTO.getMembershipNo());
        Membership movie = result.orElseThrow();

        movie.change(membershipDTO.getPrice(), membershipDTO.getMonths());
        membershipRepository.save(movie);

    }

    @Override
    public void remove(Long membershipNo) {
        membershipRepository.deleteById(membershipNo);
    }
}
