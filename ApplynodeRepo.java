package com.Onlinenodue.Repository;

import com.Onlinenodue.Entity.Applynodue;
import com.Onlinenodue.Entity.Student;
import com.Onlinenodue.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplynodeRepo extends JpaRepository<Applynodue,Integer> {


}
