package com.example.virus.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PatientDTO {
    private long id;
    private String name;
    private String email;
    private String contactNo;
    private PassportDTO passportDTO;
    private List<VirusDTO> virusDTOList;
}
