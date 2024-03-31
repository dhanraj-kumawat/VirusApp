package com.example.virus.controller;

import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.HospitalDTO;
import com.example.virus.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/hospitals")
    public ResponseEntity<ApiResponse> saveHospital(@RequestBody HospitalDTO hospitalDTO){
        return hospitalService.saveHospital(hospitalDTO);
    }
}
