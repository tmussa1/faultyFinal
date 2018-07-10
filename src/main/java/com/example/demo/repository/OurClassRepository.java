package com.example.demo.repository;


import com.example.demo.models.Instructure;
import com.example.demo.models.OurClass;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface OurClassRepository extends CrudRepository<OurClass, Long> {
    Iterable<OurClass> findAllByInstructure(Instructure instructure);
    Iterable<OurClass> findAllByYeartermAfter(int year);
}
