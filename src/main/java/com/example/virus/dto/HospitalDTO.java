package com.example.virus.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HospitalDTO {
    private long id;
    private String code;
    private String name;
    private String location;
    private List<DoctorDTO> doctorDTOS;
}

