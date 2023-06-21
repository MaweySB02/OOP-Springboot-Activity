package com.example.ACTIVITY.service;
import com.example.ACTIVITY.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student SaveStudent(Student student);
    public List<Student> FindAllStudents();
    public Student FindByID(int id);

    public void DeleteStudent(int id);
    public Student UpdateStudent(int id, Student updatedStudent);
    Optional<Object> FindByName(String name);

}
