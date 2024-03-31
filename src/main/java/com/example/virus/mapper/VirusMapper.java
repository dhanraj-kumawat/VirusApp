package com.example.virus.mapper;

import com.example.virus.dto.VirusDTO;
import com.example.virus.model.Virus;

public class VirusMapper {
    public static VirusDTO toDto(Virus virus){
        VirusDTO virusDTO = new VirusDTO();
        virusDTO.setId(virus.getId());
        virusDTO.setName(virus.getName());
        virusDTO.setVariant(virus.getVariant());

        return virusDTO;
    }

    public static Virus toEntity(VirusDTO virusDTO){
        Virus virus = new Virus();
        virus.setName(virusDTO.getName());
        virus.setVariant(virusDTO.getVariant());
        return virus;
    }
}
