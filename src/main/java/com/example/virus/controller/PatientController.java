package com.example.virus.controller;

import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.PatientDTO;
import com.example.virus.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    @PostMapping("/patients")
    public PatientDTO createPatient(@RequestBody PatientDTO patientDTO){
        return patientService.createPatient(patientDTO);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<ApiResponse> getPatient(@PathVariable long id ){
        return patientService.getPatient(id);
    }

    @GetMapping("/patients")
    public ResponseEntity<ApiResponse>  getPatients(){
        return patientService.getPatients();
    }
}
