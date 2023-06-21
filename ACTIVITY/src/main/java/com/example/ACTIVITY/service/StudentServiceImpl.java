package com.example.ACTIVITY.service;

import com.example.ACTIVITY.entity.Student;
import com.example.ACTIVITY.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student SaveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> FindAllStudents () {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student FindByID(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElseThrow(() -> new NoSuchElementException("No student found wth ID:" + id));
    }

    @Override
    public void DeleteStudent(int id){
            Optional<Student> optionalStudent = studentRepository.findById(id);
            Student studentToDelete = optionalStudent.orElseThrow(()-> new NoSuchElementException(id + "Does not exits"));
            studentRepository.delete(studentToDelete);
    }

    @Override
    public Student UpdateStudent(int id, Student updatestudent){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student id1 = optionalStudent.orElseThrow(()-> new NoSuchElementException("No student found wth ID:" + id));
        id1.setName(updatestudent.getName());
        id1.setAge(updatestudent.getAge());
        id1.setYear_level(updatestudent.getYear_level());
        return studentRepository.save(id1);
    }

    @Override
    public Optional<Object> FindByName(String name) {
        return studentRepository.findByName(name);
    }
}
