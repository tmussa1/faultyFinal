package com.example.demo.controller;

import com.example.demo.models.OurClass;
import com.example.demo.models.Student;
import com.example.demo.repository.AppRoleRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.OurClassRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String showInstructorPage(){
        return "instructurehomepage";
    }

    @RequestMapping("/viewmyclasses")
    public String viewClasses(Model model, Authentication authentication){
        model.addAttribute("classes", instructureService.getAllMyClasses(authentication));
        return "viewmyclasses";
    }

    @RequestMapping("/viewallcourses")
    public String viewAllCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "viewallcourses";
    }

    @RequestMapping("/viewcurrentsemestercourses")
    public String currentSemester(Model model, Authentication authentication){
        model.addAttribute("currentcourses", instructureService.getCurrentClasses(authentication));
        return "viewcurrentcourses";
    }

    @RequestMapping("/liststudentsinmyclass/{id}")
    public String assignGrades(@PathVariable("id") long id, Model model, Authentication authentication){
        OurClass cls = ourClassRepository.findById(id).get();
        model.addAttribute("students_class", studentRepository.findAllByOurClass(cls));
        return "listStudentsInMyClass";
    }

    @RequestMapping("/updategrade/{id}")
    public String updateGrade(@PathVariable("id") long id, Model model){
        model.addAttribute("student", studentRepository.findById(id).get());
        return "updateGrade";
    }

    @PostMapping("/savegrade")
    public String saveGarde(@ModelAttribute("student") Student student, Model model){
        studentRepository.save(student);
        return "instructurehomepage";
    }

    @RequestMapping("/viewroster")
    public String viewRoster(Model model, Authentication auth){
        model.addAttribute("students", instructureService.getRosters(auth));
        return "viewRoster";
    }

    @RequestMapping("/viewgradesheet")
    public String viewGradeSheet(Model model, Authentication auth){
        model.addAttribute("students", instructureService.getGradesheet(auth));
        return "viewgradesheet";
    }

}