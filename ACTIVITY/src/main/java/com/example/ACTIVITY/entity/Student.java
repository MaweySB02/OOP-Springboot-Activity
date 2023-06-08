package com.example.ACTIVITY.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String age;
    private String grade;
}
