package com.lee.testproject.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lee.testproject.dao.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	JavaMailSenderImpl mailSender ; 
	
	private String strRand ;
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("/member/login");
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String login_post(@RequestParam Map<String, Object> map,
		HttpServletRequest req ) throws Exception {
		
		boolean isMember =  memberService.getMember(map);
		HttpSession session =  req.getSession();
		if(isMember) {
			session.setAttribute("email", map.get("email"));
			return "success";
		}
		throw new Exception("로그아웃 실패");			
	}
	
	@PostMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest req) {
		HttpSession session =  req.getSession();
		session.invalidate();
		return "success";
	}
	
	@GetMapping("/regist")
	public ModelAndView regist() {
		return new ModelAndView("/member/regist");
	}
	
	@PostMapping("/checklogin")
	@ResponseBody
	public String checklogin(@RequestBody String email) throws Exception {
		String decodeEmail =  URLDecoder.decode(email,StandardCharsets.UTF_8);
		decodeEmail  =decodeEmail.replace("=", "");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(decodeEmail);
		map.put("email", decodeEmail);
		boolean isMember =  memberService.getMember(map);
		if(isMember)		
			return "true";
		else
			return "false";
	}
	
	
	@GetMapping("/find")
	public ModelAndView find() {
		return new ModelAndView("/member/findpsw");
	}
	
	
	
	@PostMapping("/find")
	@ResponseBody
	   public String find_post(@RequestParam Map<String, Object> map,
	      HttpServletRequest req ) throws Exception {
		
	      // 래덤한 숫자문자를 합친 문자열을 전달받은 메일 주소로 보낸다.
		  String sendToEmail = (String) map.get("email");
		   
		  Random rand = new Random();
		  strRand = "";
		  for (int i = 0; i < 4; i++) {
			  strRand +=  rand.nextInt(10);
		}
		 
	      try {
			MailUtils sendMail = new MailUtils(mailSender);
			  sendMail.setSubject("회원가입 이메일 인증");
			  String message = new StringBuffer()
					  .append("<h1>[이메일 인증]발신전용이므로 회신 불가</h1>")
					  .append("<h2>인증번호: ")
					  .append(strRand)
					  .append("</h2>")
					  .toString() ;
					  
			  sendMail.setText(message);
			  sendMail.setFrom(sendToEmail, "관리자");
			  sendMail.setTo("skylar12200@gmail.com");
			  sendMail.send();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage() ; // ?
		} 
	        
	      return "success"; 
	   }
	
	@PostMapping("/checknum")
	@ResponseBody
	public String checknum(@RequestBody String str) {
		str = str.replace("=", "");
		System.out.println("#####strRand:"+strRand);
		System.out.println("######str:"+str);

		if (str.equals(strRand))
			return "success";
		else
			return "fail";
	}
		
	
}
