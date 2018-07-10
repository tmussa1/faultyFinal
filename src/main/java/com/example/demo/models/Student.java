package com.example.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int studentNumber;
    private String yearOfEntry;

    @ManyToOne(fetch = FetchType.LAZY)
    Major major;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<OurClass> ourClass;

    public Student(){
        this.ourClass = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(String yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Set<OurClass> getOurClass() {
        return ourClass;
    }

    public void setOurClass(Set<OurClass> ourClass) {
        this.ourClass = ourClass;
    }
}
