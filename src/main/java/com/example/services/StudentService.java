package com.example.services;

import com.example.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class StudentService {

    public void addStudent(Student student){
        Student.addStudent(student);
    }

    public void deleteStudent(Long id){
        Student.deleteStudent(id);
    }

    public List<Student> getAllStudent(){
        return Student.listAll();
    }

    public void updateStudent(Student student){
        Student.updateStudent(student);
    }
}
