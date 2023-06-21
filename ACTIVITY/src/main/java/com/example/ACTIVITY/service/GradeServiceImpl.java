package com.example.ACTIVITY.service;
import com.example.ACTIVITY.entity.Grade;
import com.example.ACTIVITY.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade SaveStudentGrade (Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public List<Grade> FindAllGrade () {
        return (List<Grade>) gradeRepository.findAll();
    }

    @Override
    public Grade FindGradeByID(int id) {
        Optional<Grade> optionalGrade = gradeRepository.findById(id);
        return optionalGrade.orElseThrow(() -> new NoSuchElementException("No student found wth ID:" + id));
    }

    @Override
    public void DeleteStudentGrade(int id){
        Optional<Grade> optionalGrade = gradeRepository.findById(id);
        Grade gradeToDelete = optionalGrade.orElseThrow(()-> new NoSuchElementException(id + "Does not exits"));
        gradeRepository.delete(gradeToDelete);
    }

    @Override
    public Grade UpdateStudentGrade (int id, Grade updateStudentGrade){
        Optional<Grade> optionalGrade = gradeRepository.findById(id);
        Grade id1 = optionalGrade.orElseThrow(()-> new NoSuchElementException("No student found wth ID:" +id));
        id1.setGrade(updateStudentGrade.getGrade());
        return gradeRepository.save(id1);
    }

}
