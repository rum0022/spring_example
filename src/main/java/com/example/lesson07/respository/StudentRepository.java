package com.example.lesson07.respository;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

//@Transactional 
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{//어떤 엔티티이고, pK의 자료형은 무엇인가s

	/*@PersistenceContext
	private EntityManager em;
	
	public StudentEntity save(StudentEntity studentEntity) {
		em.persist(studentEntity);
		return studentEntity;*/
	
	//Spring data JPA
	
	// 기본제공메소드
	// 엔티티 save(엔티티) ->1.insert(id가 null)  2.update(id가 있음)
	// 엔티티 findById(id) <- select의 기능을함 (이름은 고정됨)
	// Optional<엔티티객체> findById(id)
	// 삭제는 delete 리턴타입은 void (엔티티객체)
	// List<엔티티객체> findAll();
	
	//ex02/1 - JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();// by같은거 꼭 써야함
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameIn(List<String> names);
	
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	public List<StudentEntity> findByEmailContaining(String email);
	
	public List<StudentEntity> findByNameStartingWith(String name);
	
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	
	}
	
	
