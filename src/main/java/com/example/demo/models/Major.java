package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String majorName;

    @OneToMany(mappedBy = "major", fetch = FetchType.EAGER)
    Set<Course>courses;

    @ManyToOne(fetch =FetchType.LAZY)
    Department department;

    @OneToMany(mappedBy = "major", fetch = FetchType.EAGER)
    Set<Student> students;

    public Major(){
        this.students = new HashSet<>();
        this.courses = new HashSet<>();
    }

    public void addStudents(Student stu){
        students.add(stu);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
