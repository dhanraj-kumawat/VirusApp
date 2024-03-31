package com.example.virus.mapper;

import com.example.virus.dto.DoctorDTO;
import com.example.virus.dto.HospitalDTO;
import com.example.virus.model.Doctor;
import com.example.virus.model.Hospital;

import java.util.ArrayList;
import java.util.List;

public class HospitalMapper {
    public static HospitalDTO toDto(Hospital hospital){
        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setId(hospital.getId());
        hospitalDTO.setCode(hospital.getCode());
        hospitalDTO.setName(hospital.getName());
        hospitalDTO.setLocation(hospital.getLocation());

        List<DoctorDTO> doctorDTOS= new ArrayList<>();
        hospital.getDoctors().forEach((doctor)->{
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setId(doctor.getId());
            doctorDTO.setCode(doctor.getCode());
            doctorDTO.setName(doctor.getName());
            doctorDTO.setEmail(doctor.getEmail());
            doctorDTO.setAddress(doctor.getAddress());
            doctorDTO.setContactNo(doctor.getContactNo());

            doctorDTOS.add(doctorDTO);
        });

        hospitalDTO.setDoctorDTOS(doctorDTOS);
        return hospitalDTO;
    }

    public static Hospital toEntity(HospitalDTO hospitalDTO){
        Hospital hospital = new Hospital();
        hospital.setCode(hospitalDTO.getCode());
        hospital.setName(hospitalDTO.getName());
        hospital.setLocation(hospitalDTO.getLocation());

        List<Doctor> doctors = new ArrayList<>();
        List<Hospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);
        hospitalDTO.getDoctorDTOS().forEach((doctorDTO)->{
            Doctor doctor = new Doctor();
            doctor.setCode(doctorDTO.getCode());
            doctor.setEmail(doctorDTO.getEmail());
            doctor.setAddress(doctorDTO.getAddress());
            doctor.setContactNo(doctorDTO.getContactNo());
            doctor.setName(doctorDTO.getName());
            doctor.setHospitals(hospitals);
            doctors.add(doctor);
        });

        hospital.setDoctors(doctors);
        return hospital;
    }
}
