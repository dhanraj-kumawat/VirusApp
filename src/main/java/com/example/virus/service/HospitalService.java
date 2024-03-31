package com.example.virus.service;

import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.HospitalDTO;
import org.springframework.http.ResponseEntity;

public interface HospitalService {
    ResponseEntity<ApiResponse> saveHospital(HospitalDTO hospitalDTO);
}
