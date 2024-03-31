package com.example.virus.service.impl;

import com.example.virus.dao.VirusDao;
import com.example.virus.dto.ApiResponse;
import com.example.virus.dto.VirusDTO;
import com.example.virus.mapper.VirusMapper;
import com.example.virus.model.Virus;
import com.example.virus.service.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VirusServiceImpl implements VirusService {

    @Autowired
    private VirusDao virusDao;
    @Override
    public ResponseEntity<ApiResponse> saveVirus(VirusDTO virusDTO) {
        ApiResponse apiResponse = new ApiResponse();
        Virus dbVirus = virusDao.save(VirusMapper.toEntity(virusDTO));
        apiResponse.setData(VirusMapper.toDto(dbVirus));
        apiResponse.setStatus("Success");

        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse> getViruses() {
        ApiResponse apiResponse = new ApiResponse();
        List<Virus> dbViruseslist =  virusDao.findAll();
        List<VirusDTO> virusDTOList = new ArrayList<>();
        dbViruseslist.forEach((virus) -> {
            virusDTOList.add(VirusMapper.toDto(virus));
        });
        apiResponse.setStatus("Success");
        apiResponse.setData(virusDTOList);

        return ResponseEntity.ok(apiResponse);
    }
}
