package com.ella.springbootfirstdemo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author ella
 * @date 2018/8/22
 */
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/students")
    public List<Student> studentList(){
        return studentRepository.findAll();
    }

    @PostMapping(value = "/students")
    public Student studentAdd(@RequestParam("name") String name, @RequestParam("age") Integer age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    @GetMapping(value = "/students/{id}")
    public Student findOne(@PathVariable("id") Integer id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @PutMapping(value = "/students/{id}")
    public Student updateStudent(@PathVariable("id") Integer id,
                                 @RequestParam("name") String name, @RequestParam("age") Integer age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setId(id);
        return studentRepository.save(student);
    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteOne(@PathVariable("id") Integer id){
        studentRepository.deleteById(id);
    }

    @GetMapping(value = "/students/age/{age}")
    public List<Student> findByAge(@PathVariable("age") Integer age){
        return studentRepository.findByAge(age);
    }
}
