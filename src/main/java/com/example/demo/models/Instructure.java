package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Instructure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int employeeNumber;
    private String employeeName;
    private String officeNumber;

    @OneToOne(fetch = FetchType.LAZY)
    AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    Department department;

    @OneToMany(mappedBy = "instructure", fetch = FetchType.EAGER)
    Set<OurClass> classes;

    public void addClass(OurClass ourclass){
        classes.add(ourclass);
    }


    public Instructure(){
        this.classes = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<OurClass> getClasses() {
        return classes;
    }

    public void setClasses(Set<OurClass> classes) {
        this.classes = classes;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
