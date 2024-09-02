package com.Onlinenodue.Repository;

import com.Onlinenodue.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
