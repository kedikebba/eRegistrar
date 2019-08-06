package edu.mum.cs.cs425.assignment.eregistrar.service;

import edu.mum.cs.cs425.assignment.eregistrar.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    public abstract Iterable<Student> listStudents();
    public abstract Student getStudentByID(Long studentId);
    public abstract Student saveStudent(Student student);
    public abstract void deleteStudentByID(Long studentId);
    public abstract Student searchStudentByID(Long studentId);
    public abstract List<Student> searchStudents(String string);


}
