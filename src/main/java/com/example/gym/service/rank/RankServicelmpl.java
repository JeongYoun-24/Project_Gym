package com.example.gym.service.rank;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.RankDTO;
import com.example.gym.entity.Rank;
import com.example.gym.repository.PaymentHistoryRepository;
import com.example.gym.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class RankServicelmpl implements RankService {

    private final ModelMapper modelMapper;
    private final RankRepository rankRepository;
    @Override
    public Long register(RankDTO rankDTO) {

        Rank rank = modelMapper.map(rankDTO,Rank.class);// DTO 값 Entity값으로 변환

        Rank rank2 = rankRepository.save(rank); // JPA로 DB 저장하고 저장한 값 불러오기


        return rank2.getRankNo(); // 저장한 아이디값 전달
    }

    @Override
    public RankDTO readOne(Long rankNo) {
        log.info("아이디값 찾기 "+rankNo);
        // 3. 공지 정보 읽기
        Rank rank = rankRepository
                .findById(rankNo)
                .orElseThrow(EntityNotFoundException::new);

        // 4. entity -> dto
        RankDTO rankDTO = RankDTO.of(rank);




        return rankDTO;
    }

    @Override
    public void modify(RankDTO rankDTO) {

    }

    @Override
    public void remove(Long rankNo) {

    }
}
