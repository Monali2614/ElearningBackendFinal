package com.application.controller;


import com.application.model.Career;
import com.application.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/carrer")
@CrossOrigin("*")
public class CareerController {

    @Autowired
    private CareerService careerService;



    @PostMapping("/savecareerdetails")
    public ResponseEntity<String>savecareer (
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("contactNumber") String contactNumber,
            @RequestParam("workExperience") String workExperience,
            @RequestParam("desiredDomain") String desiredDomain,
            @RequestParam("resume") MultipartFile resumeFile
    )throws IOException
    {
        Career career=new Career();
        career.setName(name);
        career.setEmail(email);
        career.setContactNumber(contactNumber);
        career.setWorkExperience(workExperience);
        career.setDesiredDomain(desiredDomain);
        career.setResume(resumeFile.getBytes());
        return new ResponseEntity<>(careerService.savecareer(career),HttpStatus.CREATED);
    }


    @GetMapping("/getcarrerdetailsbyid/{careerId}")
    public ResponseEntity<Career>getcarerbyid(Long careerId)
    {
        return new ResponseEntity<>(careerService.getcarrerbyid(careerId), HttpStatus.OK);
    }


    @GetMapping("/getcarrerdetailsofall")
    public ResponseEntity<List<Career>>getallcarerdetails()
    {
        return new ResponseEntity<>(careerService.getallcarrerdetalis(),HttpStatus.OK);
    }


}