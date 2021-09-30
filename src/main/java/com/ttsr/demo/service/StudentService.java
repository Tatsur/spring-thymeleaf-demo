package com.ttsr.demo.service;

import com.ttsr.demo.model.Student;
import com.ttsr.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public Optional<Student> findById(Long id){
       return studentRepository.findById(id);
    }
}
