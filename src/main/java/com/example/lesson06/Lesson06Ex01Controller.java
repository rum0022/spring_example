package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBo;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Ex01Controller {

	@Autowired
	private UserBo userBo;
	
	// 회원가입 화면
	// http://localhost/lesson06/ex01/add-user-view
	@GetMapping("/add-user-view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	// 회원가입 진행 (insert) - AJEX 요청
	//ajax가 요청하는 응답값은 반드시 String이다. 
	//ajax를쓰면 @ResponseBody를 붙여준다!!
	@ResponseBody
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) { 
		
		//db insert
		userBo.addUser(name, yyyymmdd, email, introduce);
		//응답값
		return "성공";
	}
	
	// 성공화면
	@GetMapping("/after-add-user-view")
	public String afterAddUserView() {
		return "lesson06/afterAddUser";
	}
	
	
}
