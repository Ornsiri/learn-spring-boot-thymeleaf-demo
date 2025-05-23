package com.ornsiri.springboot.thymeleafdemo.controller;


import com.ornsiri.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        // create a new student object
        Student student = new Student();

        // add a student to model
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public  String processStudentForm(@ModelAttribute("student") Student student) {
        // log the input data
        System.out.printf("Student : %s %s \n",student.getFirstName(), student.getLastName());
        return "student-confirmation";
    }


}
