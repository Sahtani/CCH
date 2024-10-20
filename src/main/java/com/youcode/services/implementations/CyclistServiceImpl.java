package com.youcode.services.implementations;

import com.youcode.dtos.request.CyclistRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.entities.Cyclist;
import com.youcode.entities.Team;
import com.youcode.mappers.CyclistMapper;
import com.youcode.repositories.CyclistRepository;
import com.youcode.services.api.CyclistService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CyclistServiceImpl implements CyclistService {

    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public CyclistServiceImpl(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper) {
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }

    @Override
    public List<CyclistResponseDTO> getAll() {
        return cyclistRepository.findAll().stream()
                .map(cyclistMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CyclistResponseDTO> getById(Long id) {
        return cyclistRepository.findById(id)
                .map(cyclistMapper::toResponseDTO);
    }

    @Override
    public CyclistResponseDTO save(CyclistRequestDTO cyclistRequestDTO) {
        Cyclist cyclist = cyclistMapper.toEntity(cyclistRequestDTO);
        Cyclist savedCyclist = cyclistRepository.save(cyclist);
        return cyclistMapper.toResponseDTO(savedCyclist);
    }


    public CyclistResponseDTO update(CyclistRequestDTO cyclistRequestDTO) {
//        if (!cyclistRepository.existsById(cyclistRequestDTO.id)) {
//            throw new IllegalArgumentException("Cyclist not found.");
//        }
        Cyclist cyclist = cyclistMapper.toEntity(cyclistRequestDTO);
        Cyclist updatedCyclist = cyclistRepository.save(cyclist);
        return cyclistMapper.toResponseDTO(updatedCyclist);
    }

    @Override
    public void delete(Long id) {
        cyclistRepository.deleteById(id);
    }

    public List<CyclistResponseDTO> getCyclistsSortedByName() {
        return cyclistRepository.findAll().stream()
                .sorted(Comparator.comparing(Cyclist::getName))
                .map(cyclistMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<CyclistResponseDTO> getCyclistsSortedByNationality() {
        return cyclistRepository.findAll().stream()
                .sorted(Comparator.comparing(Cyclist::getNationality))
                .map(cyclistMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
