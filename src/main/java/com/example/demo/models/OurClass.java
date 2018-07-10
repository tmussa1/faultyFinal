package com.example.demo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OurClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String crn;
    private String courseNumber;
    private String subjectCode;
    private int yearterm;
    private String name;
    private HashMap<Integer, String> grades;

    @ManyToOne(fetch = FetchType.LAZY)
    Classroom classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    Instructure instructure;

    @ManyToMany(fetch =FetchType.EAGER)
    Set<Student> students;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<AppUser> users;

    public OurClass(){
        this.students = new HashSet<>();
        this.grades = new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Instructure getInstructure() {
        return instructure;
    }

    public void setInstructure(Instructure instructure) {
        this.instructure = instructure;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public int getYearterm() {
        return yearterm;
    }

    public void setYearterm(int yearterm) {
        this.yearterm = yearterm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }

    public void addGrade(Student student, String grade){
        grades.put(student.getStudentNumber(), grade);
    }
}
