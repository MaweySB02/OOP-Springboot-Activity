package com.example.ACTIVITY.service;

import com.example.ACTIVITY.entity.Course;
import com.example.ACTIVITY.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course SaveStudentCourse (Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> FindAllCourse () {
        return (List<Course>) courseRepository.findAll();
    }


    @Override
    public void DeleteStudentCourse(int student_id){
        Optional<Course> optionalStudent = courseRepository.findById(student_id);
        Course courseToDelete = optionalStudent.orElseThrow(()-> new NoSuchElementException(student_id + "Does not exits"));
        courseRepository.delete(courseToDelete);
    }

    @Override
    public Course UpdateStudentCourse (int student_id, Course updateStudentCourse){
        Optional<Course> optionalStudent = courseRepository.findById(student_id);
        Course id1 = optionalStudent.orElseThrow(()-> new NoSuchElementException("No student found wth ID:" + student_id));
        id1.setCourse_id(updateStudentCourse.getCourse_id());
        id1.setCourse_code(updateStudentCourse.getCourse_code());
        id1.setCourse_description(updateStudentCourse.getCourse_description());
        return courseRepository.save(id1);
    }


    @Override
    public Optional<Course> FindCourseByStudent_Id(int student_id) {
        Optional<Course> optionalCourse = courseRepository.findById(student_id);
        return Optional.ofNullable(optionalCourse.orElseThrow(() -> new NoSuchElementException("No student found wth ID:" + student_id)));
    }

}
