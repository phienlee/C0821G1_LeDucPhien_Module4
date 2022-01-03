package com.example.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findByMemberName(String memberName);
}
