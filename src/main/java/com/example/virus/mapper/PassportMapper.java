package com.example.virus.mapper;

import com.example.virus.dto.PassportDTO;
import com.example.virus.model.Passport;

public class PassportMapper {
    public static Passport toEntity(PassportDTO passportDTO){
        Passport passport = new Passport();
        passport.setPassportNo(passportDTO.getPassportNo());
        return passport;
    }

    public static PassportDTO toDto(Passport passport){
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setId(passport.getId());
        passportDTO.setPassportNo(passport.getPassportNo());
        return passportDTO;
    }

}
