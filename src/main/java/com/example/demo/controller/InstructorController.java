package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class InstructorController {
    @RequestMapping("/instructor")
    @Controller
    public class StudentController {


        @RequestMapping ("/")
        public String showCurrentClasses () {
            return "currentclasses";
        }

        @RequestMapping("/roster")
        public String viewRoster(){
            return "roster";
        }

        @RequestMapping("/grades")
        public String assignGrades (){
            return "gradesform";
        }

        @RequestMapping("/gradesheets")
        public String viewGradeSheets (){
            return "gradesheets";
        }

    }
}
