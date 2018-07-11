package com.example.demo.repository;

import com.example.demo.models.AppUser;
import com.example.demo.models.OurClass;
import com.example.demo.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Iterable<Student> findAllByOurClass(OurClass ourclass);
    //Student findStudentByUserEquals(AppUser user);
}
