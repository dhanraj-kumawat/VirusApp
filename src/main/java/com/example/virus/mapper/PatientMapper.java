package com.example.virus.mapper;

import com.example.virus.dto.PassportDTO;
import com.example.virus.dto.PatientDTO;
import com.example.virus.dto.VirusDTO;
import com.example.virus.model.Passport;
import com.example.virus.model.Patient;
import com.example.virus.model.Virus;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {
    public static PatientDTO toDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setContactNo(patient.getContactNo());

        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setId(patient.getPassport().getId());
        passportDTO.setPassportNo(patient.getPassport().getPassportNo());

        patientDTO.setPassportDTO(passportDTO);

        List<VirusDTO> virusDTOList = new ArrayList<>();

        patient.getVirusList().forEach((virus)->{
            VirusDTO virusDTO = new VirusDTO();
            virusDTO.setId(virus.getId());
            virusDTO.setName(virus.getName());
            virusDTO.setVariant(virus.getVariant());
            virusDTOList.add(virusDTO);
        });

        patientDTO.setVirusDTOList(virusDTOList);

        return patientDTO;
    }
    public static Patient toEntity(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());
        patient.setContactNo(patientDTO.getContactNo());

        Passport passport = new Passport();
        PassportDTO passportDTO = patientDTO.getPassportDTO();
        passport.setPassportNo(passportDTO.getPassportNo());

        patient.setPassport(passport);


        List<Virus> virusList = new ArrayList<>();
        patientDTO.getVirusDTOList().forEach(((virusDTO )-> {
            Virus virus = new Virus();
            virus.setName(virusDTO.getName());
            virus.setVariant(virusDTO.getVariant());
            virus.setPatient(patient);
            virusList.add(virus);
        }));

        patient.setVirusList(virusList);

        return patient;
    }
}
