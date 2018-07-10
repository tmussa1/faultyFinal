package com.example.demo.models;

import javax.persistence.*;


@Entity


public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToMany(mappedBy="course")
    private long id;
    private String name;
    private String department;
    private String officeNumber;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }



}
