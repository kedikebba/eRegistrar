package edu.mum.cs.cs425.assignment.eregistrar.service.implementation;

import edu.mum.cs.cs425.assignment.eregistrar.model.Student;
import edu.mum.cs.cs425.assignment.eregistrar.repository.StudentRespository;
import edu.mum.cs.cs425.assignment.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRespository studentRespository;

    @Override
    public Iterable<Student> listStudents() {
        return studentRespository.findAll();
    }

    @Override
    public Student getStudentByID(Long studentId) {
        return studentRespository.findById(studentId).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {

        return studentRespository.save(student);
    }

    @Override
    public void deleteStudentByID(Long studentId) {
        studentRespository.deleteById(studentId);
    }

    @Override
    public Student searchStudentByID(Long studentId) {
        return studentRespository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> searchStudents(String string){
        return studentRespository.findStudentsByStudentNumberOrFirstNameOrMiddleNameOrLastName(string, string, string, string);
    };

}
