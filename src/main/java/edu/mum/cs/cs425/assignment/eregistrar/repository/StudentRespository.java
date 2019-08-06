package edu.mum.cs.cs425.assignment.eregistrar.repository;

import edu.mum.cs.cs425.assignment.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {

    //public List<Student> searchStudents(String s1, String s2, String s3, String s4);
    public abstract List<Student> findStudentsByStudentNumberOrFirstNameOrMiddleNameOrLastName(String s1, String s2, String s3, String s4);
}
