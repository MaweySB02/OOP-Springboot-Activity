package com.example.ACTIVITY.repository;

import com.example.ACTIVITY.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>, CrudRepository<Course,Integer> {
}
