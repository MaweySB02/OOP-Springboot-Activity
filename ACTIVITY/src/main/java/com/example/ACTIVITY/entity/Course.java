package com.example.ACTIVITY.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table (name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;
    private String course_code;
    private String course_description;
    private int student_id;


}
