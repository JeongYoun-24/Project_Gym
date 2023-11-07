package com.example.gym.service.member;

import com.example.gym.dto.MemberDTO;
import com.example.gym.entity.Member;
import com.example.gym.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    private final ModelMapper modelMapper;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public Member saveUsers(Member users){
        // 서버에서 validate적용
        validateDuplicateMember(users);
        return memberRepository.save(users);
    }

    private void validateDuplicateMember(Member users){
        Member findMember = memberRepository.findByEmail(users.getEmail());
        Member findMember2 = memberRepository.findByNameOrEmail(users.getName() ,users.getEmail());

        // 이미 가입된 회원인 경우 예외 발생
        if (findMember2 != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }

    }







    @Override
    public String register(MemberDTO memberDTO) {
        // dto-> entity로 데이터 복사
        Member users = modelMapper.map(memberDTO,Member.class);
        String user_id = memberRepository.save(users).getMemberId();

        return user_id;
    }

    @Override
    public MemberDTO readOne(String user_id) {
        Optional<Member> result = memberRepository.findById(user_id);
        Member users = result.orElseThrow();
        MemberDTO usersDTO = modelMapper.map(users,MemberDTO.class);

        return usersDTO;
    }

    @Override
    public void modify(MemberDTO memberDTO) {

        Optional<Member> result =  memberRepository.findById(memberDTO.getMemberId());
        Member board = result.orElseThrow();

        board.change(memberDTO.getPassword(),memberDTO.getName(),memberDTO.getEmail());
        memberRepository.save(board);

    }





    @Override
    public void remove(String user_id) {
        memberRepository.deleteById(user_id);
    }

    @Override
    public void shipModify(MemberDTO memberDTO) {

        Optional<Member> result =  memberRepository.findById(memberDTO.getMemberId());
        Member board = result.orElseThrow();

        board.change2(memberDTO.getMemberShipCheck());
        memberRepository.save(board);
    }

    @Override
    public MemberDTO login(String name, String email) {
        Member users = memberRepository.findByNameOrEmail(name,email);

        MemberDTO usersDTO = modelMapper.map(users,MemberDTO.class);

        return usersDTO;
    }

    @Override
    public MemberDTO loginId(String email) {

        Member users = memberRepository.findByEmail(email);

        MemberDTO usersDTO = modelMapper.map(users,MemberDTO.class);

        return usersDTO;
    }

    @Override
    public MemberDTO loginPwd(String memberId, String email) {
        Member users = memberRepository.findByMemberIdOrEmail(memberId,email);

        MemberDTO usersDTO = modelMapper.map(users,MemberDTO.class);

        return usersDTO;
    }

    @Override
    public void pwdUpdate(MemberDTO memberDTO) {

        Optional<Member> result =  memberRepository.findById(memberDTO.getMemberId());
        Member users = result.orElseThrow();

        users.pwdUpdate(memberDTO.getPassword(),passwordEncoder);
        memberRepository.save(users);


    }

//    @Override
//    public UsersDTO findByLoginId(String user_id, String user_pwd) {
//        return null;
//    }
//
//    @Override
//    public List<Users> allList() {
//        List<Users> itemList = usersRepository.findAll();
//
//
//        return itemList;
//    }

//    @Override
//    public UsersDTO loginId(String user_email) { // 이메일로 비밀번호 찾기
//        Users users = usersRepository.findByuser_email(user_email);
//        ;
//        UsersDTO usersDTO = modelMapper.map(users,UsersDTO.class);
//
//        return usersDTO;
//    }

//    @Override
//    public UsersDTO loginPwd(String user_id, String user_email) { //아이디와 이메일로 비밀번호 찾기
//        Optional<Users> result = usersRepository.findById(user_id);
//        Users users = result.orElseThrow();
//        UsersDTO usersDTO = modelMapper.map(users,UsersDTO.class);
//
//        return null;
//    }

//    @Override
//    public UsersDTO selectOne(String account) {
//        return mapper.selectOne(account);
//    }
//
//    @Override
//    public void keepLogin(String session, Date limitTime, String account) {
//        Map<String, Object> datas = new HashMap<>();
//        datas.put("sessionId", session);
//        datas.put("limitTime", limitTime);
//        datas.put("account", account);
//
//        mapper.keepLogin(datas);
//    }


}
