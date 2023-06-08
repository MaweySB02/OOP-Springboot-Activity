package com.example.ACTIVITY.service;
import com.example.ACTIVITY.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> FindAll();
    public Student FindByID(long id);

    public void deleteStudent(long id);
    public Student updateStudent(long id, Student updatedStudent);
    Optional<Object> findByName(String name);

}
