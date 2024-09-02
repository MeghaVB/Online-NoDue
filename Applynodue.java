package com.Onlinenodue.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Applynodue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String date;
    private String status;
    @ManyToOne
    private Subject subjects;
    @ManyToOne
    private Student students;
    @ManyToOne
    private Lecturer lecturer;
}
