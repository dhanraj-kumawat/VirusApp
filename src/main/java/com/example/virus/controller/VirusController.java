package com.example.virus.controller;

import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.VirusDTO;
import com.example.virus.service.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirusController {

    @Autowired
    private VirusService virusService;
    @PostMapping("/virus")
    public ResponseEntity<ApiResponse> saveVirus(@RequestBody VirusDTO virusDTO){
        return virusService.saveVirus(virusDTO);
    }
    @GetMapping("/virus")
    public ResponseEntity<ApiResponse> getViruses(){
        return virusService.getViruses();
    }
}
