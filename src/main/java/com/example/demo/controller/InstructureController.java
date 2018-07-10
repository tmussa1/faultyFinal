package com.example.demo.controller;

import com.example.demo.models.OurClass;
import com.example.demo.repository.AppRoleRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.OurClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/instructure")
public class InstructureController {

    @Autowired
    OurClassRepository ourClassRepository;

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructureService instructureService;


    @RequestMapping("/")
    public String showInstructorPage(){
        return "instructurePage";
    }

    @RequestMapping("/viewmyclasses")
    public String viewClasses(Model model, Authentication authentication){
        model.addAttribute("classes", instructureService.getAllMyClasses(authentication));
        return "viewClassesForm";
    }

    @RequestMapping("/viewallcourses")
    public String viewAllCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "allCourses";
    }

    @RequestMapping("/viewcurrentsemestercourses")
    public String currentSemester(Model model, Authentication authentication){
        model.addAttribute("currentcourses", instructureService.getCurrentClasses(authentication));
        return "currentCourses";
    }

    @RequestMapping("/assigngrades")
    public String assignGrades(Model model, Authentication authentication){

    }
}