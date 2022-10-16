package com.practice.jpa.bookmanager.repository;

import com.practice.jpa.bookmanager.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
