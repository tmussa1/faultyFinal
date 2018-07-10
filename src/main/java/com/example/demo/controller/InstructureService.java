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
import java.util.Date;

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
            instructure = app.getInstructure();
        }
        return ourClassRepository.findAllByInstructure(instructure);
    }

    public Iterable<OurClass> getCurrentClasses(Authentication auth){
        return ourClassRepository.findAllByYeartermAfter(LocalDateTime.now().getYear() - 1);
    }

    public Iterable<Student> getAllStudentsInMyClass(Authentication authentication){
        AppUser app = appUserRepository.findByUsername(authentication.getName());

        return studentRepository.findAllByOurClass()
    }
}
