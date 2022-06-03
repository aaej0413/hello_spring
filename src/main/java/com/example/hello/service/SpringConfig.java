package com.example.hello.service;

import com.example.hello.aop.TimeTraceAop;
import com.example.hello.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }


    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

//   @Bean
//   public MemberRepository memberRepository() {
//      qreturn new MemoryMemberRepository();
//      return new JdbcMemberRepository(dataSource);
//      return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
