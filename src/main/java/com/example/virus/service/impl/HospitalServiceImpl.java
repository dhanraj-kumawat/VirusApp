package com.example.virus.service.impl;

import com.example.virus.dao.HospitalDao;
import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.HospitalDTO;
import com.example.virus.mapper.HospitalMapper;
import com.example.virus.model.Hospital;
import com.example.virus.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalDao hospitalDao;


    @Override
    public ResponseEntity<ApiResponse> saveHospital(HospitalDTO hospitalDTO) {
        ApiResponse apiResponse = new ApiResponse();
        Hospital dbHospital =  hospitalDao.save(HospitalMapper.toEntity(hospitalDTO));
        apiResponse.setData(HospitalMapper.toDto(dbHospital));
        apiResponse.setStatus("Success");

        return ResponseEntity.ok(apiResponse);
    }
}
