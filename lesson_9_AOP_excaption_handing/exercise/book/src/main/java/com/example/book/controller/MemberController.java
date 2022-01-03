package com.example.book.controller;


import com.example.book.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Member>> getMemberById(@PathVariable(value = "id") long memberId) {
		Optional<Member> member = memberRepository.findById(memberId);
		return ResponseEntity.ok().body(member);
	}
	
	@PostMapping
	public Member addMember(@Valid @RequestBody Member member) {
		return memberRepository.save(member);
	}
}
