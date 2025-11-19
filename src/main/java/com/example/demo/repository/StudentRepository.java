package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    
    @Query("SELECT s.name, u.name FROM Student s, University u WHERE s.university.id = u.id") 
    List<Object> getAllStudentsUniversity();

    
    @Query("SELECT s.name, u.name FROM Student s, University u WHERE s.university.id = u.id AND u.name = :param") // 
    List<Object> findStudentsByUniversity(@Param("param") String univName);
}