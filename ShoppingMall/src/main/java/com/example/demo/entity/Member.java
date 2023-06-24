package com.example.demo.entity;


import com.example.demo.constant.Role;
import com.example.demo.dto.MemberFormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")		// 무슨 역할?
@Getter @Setter
@ToString
public class Member {
	
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	
	@Column(unique = true)
	private String email; 
	
	private String password;
	
	private String address;
	
	@Enumerated(EnumType.STRING)		// 그렇지 않으면 내부의 있는 것을 숫자로 판단함 0,1 이렇게
	private Role role ;
	
	public static Member createMember(MemberFormDto memberFormDto /* , PasswordEncoder passwordEncoder */) {
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		member.setAddress(memberFormDto.getAddress());
//		String password = passwordEncoder.encode(memberFormDto.getPassword());
//		member.setPassword(password);
		member.setRole(Role.USER);
		return member;
	}
}
