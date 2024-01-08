package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.respository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {

	// !!!!이번에만 BO생략 바로 repository에서 가져온다.
	@Autowired
	private StudentRepository studentRepository;
	
	// 조회하는 여러가지 방법
	@GetMapping("/1")
	public List<StudentEntity> getStudentList() {
		// 1. 전체 조회(기본제공메서드)
		//return studentRepository.findAll();
		
		// 2. 전체 조회(id기준 내림차순) //카멜케이스
		//return studentRepository.findAllByOrderByIdDesc();
		
		// 3. id기준 내림차순 3개만 조회
		//return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4. 이름 '김바다' 조회 (몇개가 올지 모르므로 find)
		//return studentRepository.findByName("김바다");
		
		// 5. in문으로 일치하는 값 모두 조회(이름)
		//return studentRepository.findByNameIn(Arrays.asList("김바다","최아름"));
		
		// 6. 여러 컬럼 값과 일치하는 데이터 조회(이름, 장래희망 일치)
		//return studentRepository.findByNameAndDreamJob("최아름", "개발자");
		
		// 7. email컬럼에 naver 키워드가 포함된 데이터 조회(like문 - %naver%)
		//return studentRepository.findByEmailContaining("naver");
		
		// 8. 이름이 김으로 시작하는 데이터 조회(like문 - 김%)
		//return studentRepository.findByNameStartingWith("김");
		
		// 9. id가 1~5인 데이터 조회(범위:between)
		//return studentRepository.findByIdBetween(1, 5);
		
	}
}
