package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {

    private MemberRepository memberRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*회원 가입*/
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 X
        extracted(member); // 중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void extracted(Member member) {
        memberRepository.findByName(member.getName())
                    .ifPresent(
               m -> {
                   throw new IllegalStateException("이미 존재하는 권지은 입니다");
               });
    }


    public List<Member> findMembers() {
     return memberRepository.findAll();
    }

    public Optional<Member> findMOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
