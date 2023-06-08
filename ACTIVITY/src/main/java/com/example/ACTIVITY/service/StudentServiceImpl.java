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
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student FindByID(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElseThrow(() -> new NoSuchElementException("No student found wth ID:" + id));
    }
    @Override
    public List<Student> FindAll () {
            return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void deleteStudent(long id){
            Optional<Student> optionalStudent = studentRepository.findById(id);
            Student studentToDelete = optionalStudent.orElseThrow(()-> new NoSuchElementException("No student found wth ID:" + id));
            studentRepository.delete(studentToDelete);
    }

    @Override
    public Student updateStudent(long id, Student updatestudent){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student stid = optionalStudent.orElseThrow(()-> new NoSuchElementException("No student found wth ID:" + id));
        stid.setName(updatestudent.getName());
        stid.setAge(updatestudent.getAge());
        stid.setGrade(updatestudent.getGrade());
        return studentRepository.save(stid);
    }

    @Override
    public Optional<Object> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
