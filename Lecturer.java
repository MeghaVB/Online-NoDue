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

public class Lecturer {
    @Id
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "lecturer")
    @JsonIgnore
    List<Applynodue> applynodueList;
}
