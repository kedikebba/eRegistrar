package edu.mum.cs.cs425.assignment.eregistrar.controllers;

import edu.mum.cs.cs425.assignment.eregistrar.model.Student;
import edu.mum.cs.cs425.assignment.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController{

    @Autowired
    public StudentService studentService;

    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    public StudentController(StudentService studentService){
//        this.studentService = studentService;
//    }

    @GetMapping(value = {"/eregistrar/student/list"})
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.listStudents());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eregistrar/student/new"})
    public String displayNewStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "student/new";
    }
    @PostMapping(value = {"/eregistrar/student/search"})
    public String searchStudent(@RequestParam("search") String search,
                             Model model) {
        List<Student> students = studentService.searchStudents(search);
        model.addAttribute("students",students)         ;

        return "student/list";
    }


    @PostMapping(value={"/eregistrar/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = "/eregistrar/student/edit/{studentId}")
    public String editStudent(@PathVariable Long studentId, Model model){
        Student student = studentService.getStudentByID(studentId);
        if(student!=null){
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = "/eregistrar/student/edit")
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student", student);
            return "student/edit";
        }
        studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId, Model model){
        studentService.deleteStudentByID(studentId);
        return "redirect: /eregistrar/student/list";
    }

}
