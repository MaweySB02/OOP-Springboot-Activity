package com.example.ACTIVITY.controller;
import com.example.ACTIVITY.entity.Student;
import com.example.ACTIVITY.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/studentDetails")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        String name = student.getName();
        if (studentService.findByName(name).isPresent()) {
            return new ResponseEntity<String>("Student with name'" + name + "' already exists", HttpStatus.BAD_REQUEST);
        }
        Long id = studentService.saveStudent(student).getId();
        return new ResponseEntity<String>("Student with ID'" + id + "' has been saved", HttpStatus.OK);
    }
    @GetMapping("/studentList")
    public ResponseEntity<List<Student>> FindAll(){
        List<Student> list =studentService.FindAll();
        return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> FindById(@PathVariable("id") String id){
        try {
            Student student = studentService.FindByID(Long.parseLong(id));
            return ResponseEntity.ok(student);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        try {
            Student updatedStudentInfo = studentService.updateStudent(id, student);
            return ResponseEntity.ok(updatedStudentInfo);
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable("id") Long id){
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student number'"+id+"' has been deleted");
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
