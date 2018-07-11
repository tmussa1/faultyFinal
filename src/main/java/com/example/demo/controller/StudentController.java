package com.example.demo.controller;

import com.example.demo.models.AppUser;
import com.example.demo.models.OurClass;
import com.example.demo.models.Student;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.OurClassRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    OurClassRepository classes;

    @Autowired
    StudentRepository students;

    @Autowired
    AppUserRepository users;


    @RequestMapping ("/")
    public String showSchedule () {

        return "schedule";
    }

    @RequestMapping("/enroll")
    public String enroll(Model model){
        //Classroom object and Instructor object should also be passed to this view
        model.addAttribute("studentclass", new OurClass());
        return "enroll";
    }

    /*
    //This is correct, but the student repository and the user repository must contain information on students and users
    @PostMapping("/saveclass")
    public String saveClass (@ModelAttribute("studentclass") OurClass c, Authentication authentication) {
        AppUser u = users.findByUsername(authentication.getName());
        Student s = students.findStudentByUserEquals(u);
        c.addStudent(s);
        classes.save(c);
        return "redirect:/enroll";
    }

    //This is correct, but the student repository and the user repository must contain information on students and users
    @RequestMapping("/transcript")
    public String viewTranscript (Model model, Authentication authentication){
        AppUser u = users.findByUsername(authentication.getName());
        Student student = students.findStudentByUserEquals(u);
        model.addAttribute("student", student);
        Student s = new Student();
        OurClass c = new OurClass();
        return "transcript";
    }
    */

}
