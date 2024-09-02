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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private int sem;

    @ManyToOne
    private Course coursess;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    List<Lecturer> lecturers;

    @OneToMany(mappedBy = "subjects")
    @JsonIgnore
    List<Applynodue> applynodues;
}
