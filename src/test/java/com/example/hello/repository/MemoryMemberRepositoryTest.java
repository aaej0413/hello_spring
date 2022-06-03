package com.example.hello.repository;

import com.example.hello.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save() {
        Member member = new Member();
        member.setName("앙응두");

        repository.save(member);

        Member result = repository.findByID(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("조형아");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("스프링");
        repository.save(member2);

        Member result = repository.findByName("스프링").get();
        assertThat(result).isEqualTo(member2);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("조형아");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("스프링");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
