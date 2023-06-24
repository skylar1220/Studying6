package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberFormDto;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/new")
	public String memberNew(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto()); 	//  화면에서 받아오고 그걸로 세팅해주고?
		return "member/memberform";
	}
	
	@PostMapping("/new")
	public String memberNewPost(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) return "/member/memberForm";
		
			try {		// alt + shift + z : try catch
				Member member = Member.createMember(memberFormDto);
				memberService.saveMember(member);
			} catch (Exception e) {
				model.addAttribute("errorMessage", e.getMessage());
				return "member/memberform";
			}
			
			return "redirect:/";
	}
	
	
}
