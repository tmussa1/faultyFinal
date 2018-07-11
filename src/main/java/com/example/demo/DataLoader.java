package com.example.demo;

import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ClassroomRepository classrooms;

    @Autowired
    InstructureRepository instructors;

    @Autowired
    DepartmentRepository departments;

    @Autowired
    CourseRepository courses;

    @Autowired
    MajorRepository majors;

    @Autowired
    OurClassRepository classes;

    @Autowired
    StudentRepository students;

    @Override
    public void run(String... strings) throws Exception {

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

        AppUser user1 = new AppUser();
        user1.setUsername("instructor");
        user1.setPassword("password");
        user1.addRole(roleRepository.findByRoleName("INSTRUCTOR"));
        userRepository.save(user1);

        OurClass ourClass1 = new OurClass();
        ourClass1.setCourseNumber("1010");
        ourClass1.setCrn("10072");
        ourClass1.setSubjectCode("BIO");
        ourClass1.setYearterm(2016);
        ourClass1.setName("Biology");
        classes.save(ourClass1);

        OurClass ourClass = new OurClass();
        ourClass.setCourseNumber("6789");
        ourClass.setCrn("456");
        ourClass.setSubjectCode("ENG");
        ourClass.setYearterm(2018);
        ourClass.setName("English");
        classes.save(ourClass);

        Student student = new Student();
        student.setName("Mussa");
        student.setStudentNumber(123);
        student.setYearOfEntry("2016");
        student.setLetterGrade("A");

        student.addClass(ourClass);
        student.addUser(user);
        students.save(student);


        Student student1 = new Student();
        student1.setName("Mussa");
        student1.setStudentNumber(123);
        student1.setYearOfEntry("2018");
        student1.setLetterGrade("B");

        student1.addClass(ourClass1);
        student1.addUser(user);
        students.save(student1);

        Classroom classroom = new Classroom();
        classroom.setBuildingName("Humanities");
        classroom.setMaxCapacity(20);
        classroom.setRoomNumber(321);
        classrooms.save(classroom);

        Instructure instructor = new Instructure();

        instructor.setEmployeeNumber(8675309);
        instructor.setEmployeeName("Dave Wolf");
        instructor.setOfficeNumber("HU322");

        instructor.addClass(ourClass1);

        ourClass.setCourseNumber("1010");
        ourClass.setCrn("10072");
        ourClass.setSubjectCode("BIO");
        ourClass.setClassroom(classroom);
        ourClass.setInstructure(instructor);
        ourClass.addUsers(user1);
        classes.save(ourClass);

        Department department = new Department();
        department.setDeptName("English");
        departments.save(department);

        Major major = new Major();

        Instructure instructor1 = new Instructure();
        instructor1.setEmployeeNumber(8675309);
        instructor1.setEmployeeName("Dave Wolf");
        instructor1.setOfficeNumber("HU322");

        Department department1 = new Department();
        department1.setDeptName("English");
        departments.save(department1);
        instructor1.setDepartment(department1);
        instructors.save(instructor1);

        Course course = new Course();
        course.setCourseNumber(101);
        course.setCourseName("Freshman Composition");
        course.setNumberOfCredits(3);
        course.setCourseDescription("First English Course");
        course.setSubjectCode("FRN 201");

        instructor1.addClass(ourClass);

        instructors.save(instructor1);
        courses.save(course);
        students.save(student);
        students.save(student1);

        //new
        Classroom classroom1 = new Classroom();
        classroom1.setBuildingName("Humanities");
        classroom1.setMaxCapacity(20);
        classroom1.setRoomNumber(321);
        classrooms.save(classroom1);


        course.setCourseNumber(101);
        course.setCourseName("Freshman Composition");
        course.setNumberOfCredits(3);
        course.setCourseDescription("First English Course");
        course.setSubjectCode("ENG");

        course.setDepartment(department);
        major.setMajorName("English");
        major.setDepartment(department);
        majors.save(major);
        course.setMajor(major);
        courses.save(course);

        user.addClass(ourClass);
        userRepository.save(user);

    }

}