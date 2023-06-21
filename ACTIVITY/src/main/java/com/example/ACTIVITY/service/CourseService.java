package com.example.ACTIVITY.service;

import com.example.ACTIVITY.entity.Course;

import java.util.List;
import java.util.Optional;


public interface CourseService {
    public Course SaveStudentCourse (Course course);
    public List<Course> FindAllCourse();

    public void DeleteStudentCourse (int student_id);
    public Course UpdateStudentCourse (int student_id, Course updatedStudentCourse);

    Optional<Course> FindCourseByStudent_Id(int student_id);
}
