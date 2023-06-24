package com.example.demo.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {
	@NotBlank(message = "이름은 필수입니다.")
	private String name;
	
	@NotBlank(message = "이메일은 필수입니다.")
	@Email(message = "이메일 형식으로 입력하세요")
	private String email; 
	
	@NotBlank(message = "비밀번호는 필수입니다.")
	@Length(min = 8, max = 16, message = "8~16자로 입력하세요")
	private String password;
	
	@NotBlank(message = "주소는 필수입니다.")
	private String address;
}
