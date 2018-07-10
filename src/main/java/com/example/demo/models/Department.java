package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String deptName;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    Set<Instructure> instructures;

    @OneToMany(mappedBy="department", fetch = FetchType.EAGER)
    Set<Course> courses;

    @OneToMany(mappedBy="department", fetch = FetchType.EAGER)
    Set<Major> majors;

    public Department(){
        this.instructures = new HashSet<>();
        this.courses = new HashSet<>();
        this.majors = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Instructure> getInstructures() {
        return instructures;
    }

    public void setInstructures(Set<Instructure> instructures) {
        this.instructures = instructures;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Major> getMajors() {
        return majors;
    }

    public void setMajors(Set<Major> majors) {
        this.majors = majors;
    }
}
