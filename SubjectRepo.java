package com.Onlinenodue.Repository;

import com.Onlinenodue.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {
    List<Subject> findBySem(Integer sem);

}
