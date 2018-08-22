package com.ella.springbootfirstdemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ella
 * @date 2018/8/22
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    List<Student> findByAge(Integer age);
}
