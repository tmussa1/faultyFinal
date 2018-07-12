package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    ClassroomRepository classrooms;

    @Autowired
    DepartmentRepository departments;

    @Autowired
    InstructureRepository instructors;

    @Autowired
    MajorRepository majors;

    @Autowired
    OurClassRepository classes;

    @Autowired
    CourseRepository courses;

    @Autowired
    StudentRepository students;

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppRoleRepository roleRepository;

    @RequestMapping ("/")
    public String showHome () {
        return "index";
    }

    @RequestMapping("/adduser")
    public String addUser (){
        return "register";
    }

    @RequestMapping("/allcourses")
    public String showAllCourses (){
        return "allcourses";
    }

    @RequestMapping("/currentsemester")
    public String showCurrentCourses (){
        return "currentsemester";
    }
    /*
    @PostConstruct
    public void fillTables (){
        AppRole aRole = new AppRole();
        aRole.setRoleName("STUDENT");
        roleRepository.save(aRole);

        aRole = new AppRole();
        aRole.setRoleName("INSTRUCTOR");
        roleRepository.save(aRole);

        AppUser user = new AppUser();
        user.setUsername("student");
        user.setPassword("password");
        user.addRole(roleRepository.findByRoleName("STUDENT"));
        userRepository.save(user);

        user = new AppUser();
        user.setUsername("instructor");
        user.setPassword("password");
        user.addRole(roleRepository.findByRoleName("INSTRUCTOR"));
        userRepository.save(user);

        Classroom classroom = new Classroom();
        classroom.setBuildingName("Humanities");
        classroom.setMaxCapacity(20);
        classroom.setRoomNumber(321);
        OurClass ourClass = new OurClass();
        classrooms.save(classroom);



        Instructure instructor = new Instructure();
        Course course = new Course();
        Major major = new Major();


        instructor.setEmployeeNumber(8675309);
        instructor.setEmployeeName("Dave Wolf");
        instructor.setOfficeNumber("HU322");


        course.setCourseNumber(101);
        course.setCourseName("Freshman Composition");
        course.setNumberOfCredits(3);
        course.setCourseDescription("First English Course");
        course.setSubjectCode("ENG");

        Department department = new Department();
        department.setDeptName("English");
        departments.save(department);
        instructor.setDepartment(department);
        instructors.save (instructor);

        course.setDepartment(department);
        major.setMajorName("English");
        major.setDepartment(department);
        majors.save(major);
        course.setMajor(major);
        courses.save(course);

        ourClass.setCourseNumber("1010");
        ourClass.setCrn("10072");
        ourClass.setSubjectCode("BIO");
        ourClass.setClassroom(classroom);
        ourClass.setInstructure(instructor);
        ourClass.setCourse(course);
        classes.save(ourClass);
    }
    */
}
