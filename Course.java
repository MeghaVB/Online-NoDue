package com.Onlinenodue.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String course;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    List<Student> students;

    @OneToMany(mappedBy = "coursess")
    @JsonIgnore
    List<Subject> subjects;
}
