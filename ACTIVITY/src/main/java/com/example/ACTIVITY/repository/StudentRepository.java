package com.example.ACTIVITY.repository;

import com.example.ACTIVITY.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Object>findByName(String name);
}
