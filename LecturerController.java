package com.Onlinenodue.Controller;

import com.Onlinenodue.Entity.Lecturer;
import com.Onlinenodue.Repository.LecturerRepo;
import com.Onlinenodue.Repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin("*")
public class LecturerController {
    @Autowired
    public LecturerRepo lecturerRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @PostMapping("/addLecturer/{cid}")
    public ResponseEntity<?> addLecturer(@RequestBody Lecturer obj,@PathVariable Integer cid)
    {
        var subject=subjectRepo.findById(cid).orElseThrow(()->new RuntimeException());
        obj.setSubject(subject);
        Random rand=new Random();
        int id=rand.nextInt(1000,9999);
        obj.setId(id);
        return new ResponseEntity<>(lecturerRepo.save(obj), HttpStatus.OK);
    }

    @GetMapping("/getLetcure")
    public ResponseEntity<?> getLecture(){
        var lecture = lecturerRepo.findAll();
        return new ResponseEntity<>(lecture,HttpStatus.OK);
    }

    @GetMapping("/getlectbyid/{id}")
    public ResponseEntity<?> getlectbyid(@PathVariable Integer id)
    {
        var lect=lecturerRepo.findById(id);
        return new ResponseEntity<>(lect,HttpStatus.OK);
    }

    @PutMapping("/updateLecture/{id}")
    public ResponseEntity<?> updateLecture(@RequestBody Lecturer obj,@PathVariable Integer id){
        var lecture = lecturerRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        lecture.setName(obj.getName());
        lecture.setEmail(obj.getEmail());
        lecture.setPhone(obj.getPhone());
        lecture.setPassword(obj.getPassword());
        lecturerRepo.save(lecture);
        return new ResponseEntity<>("data updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteLecture/{id}")
    public ResponseEntity<?> deleteLecture(@PathVariable Integer id){
        var lecturer = lecturerRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        lecturerRepo.delete(lecturer);
        return new ResponseEntity<>("lecturer deleted",HttpStatus.OK);
    }
}
