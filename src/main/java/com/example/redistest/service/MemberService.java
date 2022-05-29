package com.example.redistest.service;

import com.example.redistest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private Long roomId = 1L;


    @Cacheable(key = "#id",value = "0L")
    public String existMember(Long id){

        return "id = " + id + "|| isSuccess = " + memberRepository.existsMemberByRoomIdAndUserId(0L, id);
    }

    public String existMemberNonCache(Long id){

        return "id = " + id + "|| isSuccess = " + memberRepository.existsMemberByRoomIdAndUserId(0L, id);
    }
}
