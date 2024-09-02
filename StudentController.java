package com.Onlinenodue.Controller;

import com.Onlinenodue.Entity.Student;
import com.Onlinenodue.Repository.CourseRepo;
import com.Onlinenodue.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin("*")
public class StudentController {
    @Autowired
    public StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/addStudent/{cid}")
    public ResponseEntity<?> addStudent(@RequestBody Student obj,@PathVariable Integer cid){
       var course=courseRepo.findById(cid).orElseThrow(()->new RuntimeException("Not found"));
       obj.setCourse(course);
        Random rand=new Random();
        int sid=rand.nextInt(1000,9999);
        obj.setId(sid);
        return new ResponseEntity<>( studentRepo.save(obj), HttpStatus.OK);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<?> getStudents(){
        var students = studentRepo.findAll();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/getStudentsbyid/{id}")
    public ResponseEntity<?> getStudentsbyid(@PathVariable String id){
        var students = studentRepo.findByUsn(id);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @PutMapping("/updateStudents/{usn}")
    public ResponseEntity<?> updateStudents(@RequestBody Student obj,@PathVariable String usn){
        var student = studentRepo.findByUsn(usn).orElseThrow(()->new RuntimeException("not found"));
        student.setName(obj.getName());
        student.setEmail(obj.getEmail());
        student.setPhone(obj.getEmail());
        student.setPassword(obj.getPassword());
        studentRepo.save(student);
        return new ResponseEntity<>("data updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        var student = studentRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        studentRepo.delete(student);
        return new ResponseEntity<>("student deleted",HttpStatus.OK);
    }
}
