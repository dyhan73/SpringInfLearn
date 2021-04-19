package com.example.hello.repository;

import com.example.hello.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("Spirng");

        repository.save(member);
        System.out.println(member);

        Member result = repository.findById(member.getId()).get();
//        assertEquals(member.getName(), result.getName());
//        assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        assertThat(member1).isEqualTo(result);
    }

    @Test
    void findAll() {
//        Member member1 = new Member();
//        member1.setName("Spring");
        this.findByName();

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}