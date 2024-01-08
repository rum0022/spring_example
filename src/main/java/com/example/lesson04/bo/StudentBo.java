package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.respository.StudentRepository;

@Service
public class StudentBo {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired //오토와이어드 어노테이션은 따로따로 써줘야한다.
	private StudentRepository studentRepository;
	
	// JPA로 insert
	public StudentEntity addStudent(
		String name, String phoneNumber, 
		String email, String dreamJob) {
			
	StudentEntity student = StudentEntity.builder()  // 객체를 만드는 동시에 세팅까지 해줌 
					.name(name)
					.phoneNumber(phoneNumber)
					.email(email)
					.dreamJob(dreamJob)
					.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면 생략가능 
					.build();
			return	studentRepository.save(student); //entity를 넘겨준다. 이 이후에는 id도 채워짐
		}	
	
	
	// 아래 해놓은건 Mybatis로 insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// jpa로 update
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 업데이될 대상을 select로 일단 가져와서 
		StudentEntity student = studentRepository.findById(id).orElse(null); // 객체가 없으면 null로 넣을거고 있으면 객체가 들어갈것이다. 
		
		//update -> save로 한다., null검사해야함
		if (student != null) {
		student = student.toBuilder() //기존 필드값들은 유지하고 일부 필드만 변경-> toBuilder
		.dreamJob(dreamJob)
		.build(); // student = student.toBuilder()!!!반드시 다시 student를 저장한다!! 
		}
		
		// update
		student = studentRepository.save(student);
		
		return student; // student or null
	}
	
	// jpa로 delete
	
	public void deletdStudentById(int id) {
		
		// 삭제할 대상 select
		// 방법 1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		// 방법 2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id); //null검사를 하는 엔티티
		studentOptional.ifPresent(s -> studentRepository.delete(s)); // s = StudentEntity
	
	}
	
	
	
	
	
	
	public Student getRealtorById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
}

