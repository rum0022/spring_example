package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBo;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller //jsp를 내리는 경우 responsebody가 있으면 안됨
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBo userBo;
	
	// 회원가입 화면을 만들기
	// http://localhost/lesson04/ex01/add-user-view 
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	// String은 뷰의 경로이다.
	public String addUserView() {
		return "lesson04/addUser"; //jsp view경로
	}
	
	
	//회원가입 insert => 입력 성공 화면
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// DB insert
		userBo.addUser(name, yyyymmdd, email, introduce);
		return "lesson04/afterAddUser"; //다른화면으로 리턴
	}
	
	// 최근에 가입된 한명의 유저
	// http://localhost/lesson04/ex01/latest-user-view 
	@GetMapping("/latest-user-view")
	public String lateatUserView(Model model) { // Model: view화면에 데이터를 넘겨주는 객체
		// DB select(최신가입자)
		User user = userBo.getLatestUser();
		
		//모델주머니에 데이터를 담는다.(매개체) - 결과적으로 jsp에서 꺼내쓴다  -> MVC2의 이야기 
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입된 유저정보");
		return "lesson04/latestUser"; //결과화면 jsp
	}
}
