package com.example.virus.service;

import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.VirusDTO;
import com.example.virus.model.Virus;
import org.springframework.http.ResponseEntity;

public interface VirusService {
    ResponseEntity<ApiResponse> saveVirus(VirusDTO virusDTO);

    ResponseEntity<ApiResponse> getViruses();
}

