package com.youcode.mappers;

import com.youcode.dtos.request.CyclistRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.entities.Cyclist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CyclistMapper extends GenericMapper<Cyclist, CyclistRequestDTO, CyclistResponseDTO> {

}


// Convert entity Cyclist to CyclistResponseDTO
//    public CyclistResponseDTO toResponseDTO(Cyclist cyclist) {
//        return new CyclistResponseDTO(
//                cyclist.getId(),
//                cyclist.getName(),
//                cyclist.getAge(),
//                cyclist.getNationality(),
//                cyclist.getTeam().getId()
//        );
//    }

//    // Convert CyclistRequestDTO to entity Cyclist
//    public Cyclist toEntity(CyclistRequestDTO dto) {
//        Team team = teamRepository.findById(dto.teamId())
//                .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + dto.teamId()));
//
//        Cyclist cyclist = new Cyclist();
//        cyclist.setName(dto.name());
//        cyclist.setAge(dto.age());
//        cyclist.setNationality(dto.nationality());
//        cyclist.setTeam(team);
//        return cyclist;
//    }

