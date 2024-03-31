package com.example.virus.controller;

import com.example.virus.dto.PassportDTO;
import com.example.virus.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassportController {

    @Autowired
    PassportService passportService;

    @PostMapping("/passports")
    public PassportDTO savePassport(@RequestBody PassportDTO passportDTO){
        return passportService.savePassport(passportDTO);
    }
}
