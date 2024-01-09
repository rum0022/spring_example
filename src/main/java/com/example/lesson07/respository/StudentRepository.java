package com.example.lesson07.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	// ex02/2 -JPQL(entity에 조회하고 db에 안감) 쿼리어노테이션 쓸때, Db에 직접 할때
	//@Query(value = "select st from StudentEntity st where st.dreamJob =:dreamJob") // JPQL문법(엔티티조회)
	@Query(value = "select * from new_student where dreamJob =:dreamJob", nativeQuery = true) // nativeQuery SQL문 조회
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	
	}
	
	
