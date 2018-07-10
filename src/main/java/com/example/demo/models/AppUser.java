package com.example.demo.models;

import com.example.demo.models.AppRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    Set<AppRole> roles;

    @OneToOne(mappedBy="appUser", fetch = FetchType.EAGER)
    Instructure instructure;

    @ManyToMany(mappedBy = "users" , fetch = FetchType.EAGER)
    Set<OurClass>classes;

    public AppUser(){
        this.roles = new HashSet<>();
    }

    public AppUser(String userName, String passWord) {
        this.roles = new HashSet<>();
        this.classes = new HashSet<>();
        this.username = userName;
        this.password = passWord;
    }

    public void addRole(AppRole role){
        roles.add(role);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }

    public Instructure getInstructure() {
        return instructure;
    }

    public void setInstructure(Instructure instructure) {
        this.instructure = instructure;
    }
}

