package com.Onlinenodue.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Student {
    @Id
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String usn;
    private int sem;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "students")
    @JsonIgnore
    List<Applynodue>  applynodues;
}
