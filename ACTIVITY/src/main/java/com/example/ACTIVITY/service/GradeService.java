package com.example.ACTIVITY.service;

import com.example.ACTIVITY.entity.Course;
import com.example.ACTIVITY.entity.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    public Grade SaveStudentGrade (Grade grade);
    public List<Grade> FindAllGrade();
    public Grade FindGradeByID(int id);

    public void DeleteStudentGrade (int id);
    public Grade UpdateStudentGrade (int id, Grade updatedStudentGrade);


}
