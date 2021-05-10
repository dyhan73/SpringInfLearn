package com.example.hello.service;

import com.example.hello.domain.Member;
import com.example.hello.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository repository;


    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring test");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.toString(), findMember.toString());
    }

    @Test
    public void 중혹회원예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring test");

        Member member2 = new Member();
        member2.setName("spring test");

        // when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        memberService.join(member2);


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}