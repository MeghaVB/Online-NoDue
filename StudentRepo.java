package com.Onlinenodue.Repository;

import com.Onlinenodue.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Integer> {


    Optional<Student> findByUsn(String usn);
}
