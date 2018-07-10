package com.example.demo.repository;


import com.example.demo.models.OurClass;
import org.springframework.data.repository.CrudRepository;

public interface OurClassRepository extends CrudRepository<OurClass, Long> {
}
