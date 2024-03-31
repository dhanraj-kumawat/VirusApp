package com.example.virus.service;

import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.PatientDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    ResponseEntity<ApiResponse> getPatient(long id);
    ResponseEntity<ApiResponse> getPatients();
}
