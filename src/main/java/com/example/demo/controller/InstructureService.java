package com.example.demo.controller;

import com.example.demo.models.AppUser;
import com.example.demo.models.Instructure;
import com.example.demo.models.OurClass;
import com.example.demo.models.Student;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.InstructureRepository;
import com.example.demo.repository.OurClassRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class InstructureService {

    private AppUser appUser;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    OurClassRepository ourClassRepository;

    @Autowired
    InstructureRepository instructureRepository;

    @Autowired
    StudentRepository studentRepository;

    public Iterable<OurClass> getAllMyClasses(Authentication auth){

        AppUser app = appUserRepository.findByUsername(auth.getName());

        Instructure instructure = null;

        if(app != null){
            instructure= instructureRepository.findByAppUser(app);
        }
        return ourClassRepository.findAllByInstructure(instructure);
    }

    public Iterable<OurClass> getCurrentClasses(Authentication auth){
        return ourClassRepository.findAllByYeartermGreaterThan(LocalDateTime.now().getYear() - 1);
    }

    public Set<Student> getRosters(Authentication auth){
        Iterable<OurClass> ourclasses = getAllMyClasses(auth);
        Set<Student> students = new HashSet<>();

        for(OurClass cls: ourclasses) {
            for (Student std : cls.getStudents()) {
                students.add(std);
            }
        }
        return students;
    }
    public Set<Student> getGradesheet(Authentication auth){

        Iterable<OurClass> ourclasses = getAllMyClasses(auth);
        Set<Student> students = new HashSet<>();
        Date date = new Date();

        for(OurClass cls: ourclasses) {
            for (Student std : cls.getStudents()) {
                if(LocalDateTime.now().getYear() > cls.getYearterm()) {
                    students.add(std);
                }
            }
        }
        return students;
    }

}
