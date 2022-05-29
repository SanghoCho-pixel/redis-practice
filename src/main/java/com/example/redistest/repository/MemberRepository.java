package com.example.redistest.repository;

import com.example.redistest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsMemberByRoomIdAndUserId(Long RoomId, Long UserId);


}
