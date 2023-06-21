package com.example.ACTIVITY.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table (name = "students")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should be provided")
    private String name;


    @Min(value = 5, message = "Enter a valid age")
    @Max(value = 96, message = "Enter a valid age")
    private int age;

    @NotEmpty(message = "Student's year level should be provided")
    private String year_level;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
