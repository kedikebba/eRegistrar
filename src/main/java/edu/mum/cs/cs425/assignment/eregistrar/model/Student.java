package edu.mum.cs.cs425.assignment.eregistrar.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false)
    private String studentNumber;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private Double cumulativeGradePointAverage;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    private String isInternational;

    public Student() {
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, Double cumulativeGradePointAverage, LocalDate enrollmentDate, String isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cumulativeGradePointAverage = cumulativeGradePointAverage;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCumulativeGradePointAverage() {
        return cumulativeGradePointAverage;
    }

    public void setCumulativeGradePointAverage(Double cumulativeGradePointAverage) {
        this.cumulativeGradePointAverage = cumulativeGradePointAverage;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(String international) {

//        boolean returnValue = false;
//        if ("1".equalsIgnoreCase(international) || "Yes".equalsIgnoreCase(international) ||
//                "true".equalsIgnoreCase(international) || "on".equalsIgnoreCase(international))
//            returnValue = true;
       // return returnValue;
        this.isInternational = international;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cumulativeGradePointAverage=" + cumulativeGradePointAverage +
                ", enrollmentDate=" + enrollmentDate +
                ", isInternational=" + isInternational +
                '}';
    }


}
