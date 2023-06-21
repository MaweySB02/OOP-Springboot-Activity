package com.example.ACTIVITY.repository;

import com.example.ACTIVITY.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer>, CrudRepository<Grade, Integer> {
}
