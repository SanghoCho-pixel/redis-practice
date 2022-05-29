package com.example.redistest.controller;

import com.example.redistest.entity.Member;
import com.example.redistest.repository.MemberRepository;
import com.example.redistest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping
    public void createMemberList(){
        for (int i = 0; i < 1000; i++) {
            Long roomId = 0L;
            Long userId = (long)i;

            Member member = new Member();
            member.setRoomId(roomId);
            member.setUserId(userId);

            memberRepository.save(member);
        }
    }

    @GetMapping("/exist")
    public String existMember(){
        double dValue = Math.random();
        long id = (long)(dValue * 1000);
        return memberService.existMember(id);
    }

    @GetMapping("/exist-non-cache")
    public String existMemberNonCache(){
        double dValue = Math.random();
        long id = (long)(dValue * 1000);
        return memberService.existMemberNonCache(id);
    }

    @GetMapping("/exist/{id}")
    public String existMember(@PathVariable Long id){
        return memberService.existMember(id);
    }

    @GetMapping("/exist-non-cache/{id}")
    public String existMemberNonCache(@PathVariable Long id){
        return memberService.existMemberNonCache(id);
    }
}
