package com.Onlinenodue.Controller;

import com.Onlinenodue.Entity.Applynodue;
import com.Onlinenodue.Entity.Student;
import com.Onlinenodue.Entity.Subject;
import com.Onlinenodue.Repository.ApplynodeRepo;
import com.Onlinenodue.Repository.LecturerRepo;
import com.Onlinenodue.Repository.StudentRepo;
import com.Onlinenodue.Repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ApplynodueController {

    @Autowired
    private ApplynodeRepo applynodeRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private LecturerRepo lecturerRepo;

    @PostMapping("/Applynodue/{studentid}")
    public ResponseEntity<?> ApplyNodue(@RequestBody Applynodue obj, @PathVariable String studentid)
    {

        var student = studentRepo.findByUsn(studentid).orElseThrow(() -> new RuntimeException("Student Not Found"));

        var subjects = subjectRepo.findBySem(student.getSem());

        for (Subject subject : subjects) {

            Applynodue nodue = new Applynodue();
            nodue.setStudents(student);
            nodue.setSubjects(subject);
            nodue.setStatus("Pending");
            nodue.setDate(obj.getDate());
            applynodeRepo.save(nodue);
        }
        return new ResponseEntity<>("Nodue Apply Successfully", HttpStatus.OK);
    }

    @GetMapping("/getnodue")
    public ResponseEntity<?> getnodue()
    {
        var due=applynodeRepo.findAll();
        return new ResponseEntity<>(due,HttpStatus.OK);
    }

    @PutMapping("/Approvenodue/{lid}")
    public ResponseEntity<?> Approvenodue(@RequestBody Applynodue obj,@PathVariable Integer lid)
    {
        var lect=lecturerRepo.findById(lid).orElseThrow(()->new RuntimeException("Lect Id not found"));

        var apply=applynodeRepo.findById(obj.getAid()).orElseThrow(()->new RuntimeException("Apply Id not found"));
        apply.setStatus("Approved");
        apply.setLecturer(lect);
        applynodeRepo.save(apply);
        return new ResponseEntity<>("Approved",HttpStatus.OK);
    }
}
