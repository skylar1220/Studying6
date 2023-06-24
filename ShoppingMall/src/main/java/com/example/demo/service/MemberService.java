package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional		// 여러개의 디비를 동시에 사용할 때 하나 성공 하나 에러면 그거를 하나의 쿼리로 묶어서 전부 성공해야 반영하는 기능
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	
	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		} 
	}
	
	public Member saveMember(Member member) {		// 전달된 디비로 생성된 아이디 값등을 리턴하는 애?
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}
	
}
