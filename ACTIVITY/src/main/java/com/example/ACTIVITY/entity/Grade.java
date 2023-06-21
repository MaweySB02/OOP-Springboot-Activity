package com.example.ACTIVITY.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Table(name = "grade")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grade;
    private Integer student_Id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne
    @JoinColumn(name = "id")
    private Student student;

    public Integer getStudent_id() {
        return student_Id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_Id = student_id;
    }


}
