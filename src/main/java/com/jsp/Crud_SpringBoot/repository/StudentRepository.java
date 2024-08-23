package com.jsp.Crud_SpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Crud_SpringBoot.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
	List<Student> findByName(String name);
	
	List<Student> findByMobile(Long mobile);
	
	List<Student> findByGender(String gender);
	
	List<Student> findByMathGreaterThanAndScienceGreaterThanAndEnglishGreaterThan(int marks,int marks2, int marks3);
	
}
