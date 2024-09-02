package com.Onlinenodue.Controller;

import com.Onlinenodue.Entity.Course;
import com.Onlinenodue.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CourseController {
    @Autowired
    public CourseRepo courseRepo;

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody Course obj){
        courseRepo.save(obj);
        return new ResponseEntity<>("course added", HttpStatus.OK);
    }
    @GetMapping("/getCourse")
    public ResponseEntity<?> getCourse(){
        var course = courseRepo.findAll();
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<?> updateCourse(@RequestBody Course obj,@PathVariable Integer id){
        var course = courseRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        course.setCourse(obj.getCourse());
        courseRepo.save(course);
        return new ResponseEntity<>("course updated",HttpStatus.OK);
    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        var course = courseRepo.findById(id).orElseThrow(()->new RuntimeException("no fond"));
        courseRepo.delete(course);
        return new ResponseEntity<>("delete successfully",HttpStatus.OK);

    }
}
