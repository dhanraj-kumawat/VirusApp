package com.example.virus.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DoctorDTO {
    private long id;
    private String code;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private List<HospitalDTO> hospitalDTOS;
}

