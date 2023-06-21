package com.example.ACTIVITY.repository;

import com.example.ACTIVITY.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer>, CrudRepository<Student, Integer> {

    Optional<Object>findByName(String name);
}
