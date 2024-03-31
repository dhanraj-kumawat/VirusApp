package com.example.virus.service.impl;

import com.example.virus.dao.PassportDao;
import com.example.virus.dto.PassportDTO;
import com.example.virus.mapper.PassportMapper;
import com.example.virus.model.Passport;
import com.example.virus.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    PassportDao passportDao;
    @Override
    public PassportDTO savePassport(PassportDTO passportDTO) {
        Passport passport = PassportMapper.toEntity(passportDTO);
        Passport dbPassport= new Passport();
        try {
             dbPassport = passportDao.save(passport);
        }
        catch (Exception  e){
            System.out.println(e.getMessage());
        }

        return PassportMapper.toDto(dbPassport);
    }
}
