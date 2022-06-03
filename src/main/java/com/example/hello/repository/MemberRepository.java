package com.example.hello.repository;

import com.example.hello.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findByID(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
