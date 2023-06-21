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
@RequestMapping("/StudentDetails")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/SaveStudent")
    public ResponseEntity<String> SaveStudent(@RequestBody Student student){
        String name = student.getName();
        if (studentService.FindByName(name).isPresent()) {
            return new ResponseEntity<String>("The data of this student already exist:'" + name + "'", HttpStatus.BAD_REQUEST);
        }
        Integer id = studentService.SaveStudent(student).getId();
        return new ResponseEntity<String>("Student with this ID has been successfully saved:'" + id + "'", HttpStatus.OK);
    }


    @GetMapping("'/StudentList'")
    public ResponseEntity<List<Student>> FindAllStudents(){
        List<Student> list = studentService.FindAllStudents();
        return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
    }


    @GetMapping("/GetStudentById/{id}")
    public ResponseEntity<Student> FindById(@PathVariable("id") String id){
        try {
            Student student = studentService.FindByID(Integer.parseInt(id));
            return ResponseEntity.ok(student);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/UpdateStudent/{id}")
    public ResponseEntity<Student> UpdateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
        try {
            Student updatedStudentInfo = studentService.UpdateStudent(id, student);
            return ResponseEntity.ok(updatedStudentInfo);
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> DeleteStudent (@PathVariable("id") Integer id){
        try {
            studentService.DeleteStudent(id);
            return ResponseEntity.ok("Student number'"+id+"' successfully deleted");
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
