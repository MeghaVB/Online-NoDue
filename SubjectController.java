package com.Onlinenodue.Controller;

import com.Onlinenodue.Entity.Subject;
import com.Onlinenodue.Repository.CourseRepo;
import com.Onlinenodue.Repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class SubjectController {
    @Autowired
    public SubjectRepo subjectRepo;

    @Autowired
    public CourseRepo courseRepo;

    @PostMapping("/addSubjects/{id}")
    public ResponseEntity<?> addSubject(@RequestBody Subject obj, @PathVariable Integer id){
        var course = courseRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        obj.setCoursess(course);
        subjectRepo.save(obj);
        return new ResponseEntity<>("subject added", HttpStatus.OK);
    }
    @GetMapping("/getSubjects")
    public ResponseEntity<?> getSubjects(){
        var subjects = subjectRepo.findAll();
        return new ResponseEntity<>(subjects,HttpStatus.OK);
    }
    @GetMapping("/getsubjectsbycourseid/{cid}")
    public ResponseEntity<?> getsubjectsbycourseid(@PathVariable Integer cid)
    {
        var subjects=subjectRepo.findById(cid);
        return new ResponseEntity<>(subjects,HttpStatus.OK);
    }

    @PutMapping("/updateSubjects/{id}")
    public ResponseEntity<?> updateSubjects(@RequestBody Subject obj,@PathVariable Integer id){
        var subject = subjectRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        subject.setSubject(obj.getSubject());
        subjectRepo.save(subject);
        return new ResponseEntity<>("subject updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteSubject/{id}")
    public ResponseEntity<?> deleteSubjects(@PathVariable Integer id){
        var subject = subjectRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        subjectRepo.delete(subject);
        return new ResponseEntity<>("subject deleted ",HttpStatus.OK);
    }
}
