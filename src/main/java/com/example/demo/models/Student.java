package com.example.demo.models;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentNumber;

    private String name;

    @ManyToOne(mappedBy="students")
    private Major major;

    private String yearOfEntry;

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(String yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }
}
