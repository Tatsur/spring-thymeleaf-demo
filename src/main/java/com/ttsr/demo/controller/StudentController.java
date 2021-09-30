package com.ttsr.demo.controller;

import com.ttsr.demo.model.Student;
import com.ttsr.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Log4j2
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    @ModelAttribute("students")
    public List<Student> getStudents(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return  studentService.findById(id).get();
    }

    @PostMapping
    public String save(@Validated @ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/students";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteById(id);
        return "redirect:/students";
    }
}
