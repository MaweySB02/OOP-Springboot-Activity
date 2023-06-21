package com.example.ACTIVITY.controller;


import com.example.ACTIVITY.entity.Grade;
import com.example.ACTIVITY.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/GradeDetails")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/SaveStudentGrade")
    public ResponseEntity<String> SaveStudentGrade (@RequestBody Grade grade){
        Integer Student_id = gradeService.SaveStudentGrade(grade).getStudent_id();
        return new ResponseEntity<String>("The Course of the Student with this ID has been successfully saved:'" + Student_id + "'", HttpStatus.OK);
    }

    @GetMapping("/GetAllGrades")
    public ResponseEntity<List<Grade>> FindAllGrade() {
        List<Grade> grade = gradeService.FindAllGrade();
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @GetMapping("/GetGradeById/{student_id}")
    public ResponseEntity<Grade> FindGradeById(@PathVariable("student_id") String student_id){
        try {
            Grade grade = gradeService.FindGradeByID(Integer.parseInt(student_id));
            return ResponseEntity.ok(grade);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/UpdateGradeById/{student_id}")
    public ResponseEntity<Grade> UpdateStudentGrade(@PathVariable("student_id") Integer student_id, @RequestBody Grade grade){
        try {
            Grade updatedStudentGrade = gradeService.UpdateStudentGrade(student_id, grade);
            return ResponseEntity.ok(updatedStudentGrade);
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteGrade/{student_id}")
    public ResponseEntity<String> DeleteStudentGrade (@PathVariable("student_id") Integer student_id){
        try {
            gradeService.DeleteStudentGrade(student_id);
            return ResponseEntity.ok("Student number'"+student_id+"' successfully deleted");
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
