package com.example.ACTIVITY.controller;

import com.example.ACTIVITY.entity.Course;
import com.example.ACTIVITY.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/CourseDetails")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/SaveStudentCourse")
    public ResponseEntity<String> SaveStudentCourse (@RequestBody Course course){
        Integer Student_id = courseService.SaveStudentCourse(course).getStudent_id();
        return new ResponseEntity<String>("The Course of the Student with this ID has been successfully saved:'" + Student_id + "'", HttpStatus.OK);
    }

    @GetMapping("/GetAllCourse")
    public ResponseEntity<List<Course>> FindAllCourse() {
        List<Course> courses = courseService.FindAllCourse();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/GetCourseById/{student_id}")
    public ResponseEntity<Optional<Course>> FindCourseByStudent_Id(@PathVariable("student_id") String student_id){
        try {
            Optional<Course> course = courseService.FindCourseByStudent_Id(Integer.parseInt(student_id));
            return ResponseEntity.ok(course);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/UpdateStudentCourse/{student_id}")
    public ResponseEntity<Course> UpdateStudentCourse(@PathVariable("student_id") Integer student_id, @RequestBody Course course){
        try {
            Course updatedStudentCourse = courseService.UpdateStudentCourse(student_id, course);
            return ResponseEntity.ok(updatedStudentCourse);
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteStudentCourse/{student_id}")
    public ResponseEntity<String> DeleteStudentCourse (@PathVariable("student_id") Integer student_id){
        try {
           courseService.DeleteStudentCourse(student_id);
            return ResponseEntity.ok("The Course of student number'"+student_id+"' has been successfully deleted");
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
