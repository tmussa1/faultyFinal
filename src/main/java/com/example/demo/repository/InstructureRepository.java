package com.example.demo.repository;

import com.example.demo.models.Instructure;
import org.springframework.data.repository.CrudRepository;

public interface InstructureRepository extends CrudRepository<Instructure, Long> {
    Instructure findByEmployeeName(String name);
}
