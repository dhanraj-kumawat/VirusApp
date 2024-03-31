package com.example.virus.service.impl;

import com.example.virus.dao.PatientDao;
import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.PatientDTO;
import com.example.virus.exception.PatientIdNotFoundException;
import com.example.virus.mapper.PatientMapper;
import com.example.virus.model.Patient;
import com.example.virus.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = PatientMapper.toEntity(patientDTO);
        Patient dbPatient = null;
        try {
            dbPatient =  patientDao.save(patient);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(dbPatient == null)
            return new PatientDTO();
        return PatientMapper.toDTO(dbPatient);
    }

    @Override
    public ResponseEntity<ApiResponse> getPatient(long id) {
        Optional<Patient> optionalPatient= patientDao.findById(id);
        if(optionalPatient.isEmpty()){
            System.out.println("no patient found!");
            throw new PatientIdNotFoundException("Patient with id "+ id+ " is not found!");
        }

        Patient dbPatient = optionalPatient.get();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setPath(httpServletRequest.getRequestURI());
        apiResponse.setStatus("Success");
        apiResponse.setData(PatientMapper.toDTO(dbPatient));
        return  ResponseEntity.ok().body(apiResponse);

    }

    @Override
    public ResponseEntity<ApiResponse> getPatients() {
        List<Patient> dbPatients = patientDao.findAll();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Success");
        apiResponse.setPath(httpServletRequest.getRequestURI());
        if(dbPatients.isEmpty()) {
            return ResponseEntity.ok(apiResponse);
        }
        List<PatientDTO> patientDTOList =  dbPatients.stream().map(PatientMapper::toDTO).toList();
        apiResponse.setData(patientDTOList);
        return ResponseEntity.ok(apiResponse);
    }
}
