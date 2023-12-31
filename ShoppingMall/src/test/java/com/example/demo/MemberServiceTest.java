package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.MemberFormDto;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

import jakarta.transaction.Transactional;

@SpringBootTest
//@Transactional
public class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
//	@Autowired
//	PasswordEncoder passwordEncoder ; 
	
	public Member createMember() {
		MemberFormDto memberFormDto = new MemberFormDto();
		memberFormDto.setEmail("test@email.com");
		memberFormDto.setName("홍길동");
		memberFormDto.setAddress("대한민국");
//		memberFormDto.setPassword("1234");
		
		return Member.createMember(memberFormDto /* , passwordEncoder */);
	}
	
	@Test
	@DisplayName("회원가입 테스트")
	public void saveMemberTest() {
		Member member = createMember();
		Member savedMember =  memberService.saveMember(member);
		assertEquals(member.getEmail(), savedMember.getEmail());
		assertEquals(member.getName(), savedMember.getName());
		assertEquals(member.getAddress(), savedMember.getAddress());
//		assertEquals(member.getPassword(), savedMember.getPassword());
		assertEquals(member.getRole(), savedMember.getRole());
	}
}
