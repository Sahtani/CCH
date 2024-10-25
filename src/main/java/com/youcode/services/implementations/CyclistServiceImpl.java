package com.youcode.services.implementations;

import com.youcode.dtos.request.CyclistRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.entities.Cyclist;
import com.youcode.entities.Team;
import com.youcode.mappers.CyclistMapper;
import com.youcode.repositories.CyclistRepository;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.api.CyclistService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CyclistServiceImpl implements CyclistService {

    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;
    private final TeamRepository teamRepository;
    @Override
    public List<CyclistResponseDTO> getAll() {
        return cyclistRepository.findAll().stream()
                .map(cyclistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CyclistResponseDTO> getById(Long id) {
        return cyclistRepository.findById(id)
                .map(cyclistMapper::toDto);
    }

    @Override
    public CyclistResponseDTO save(CyclistRequestDTO cyclistRequestDTO) {
        final Team team = teamRepository.findById(cyclistRequestDTO.teamId()).orElseThrow(() -> new EntityNotFoundException("Team with ID " + cyclistRequestDTO.teamId() + " not found."));

        final Cyclist mapperCyclist = cyclistMapper.toEntity(cyclistRequestDTO);
        mapperCyclist.setTeam(team);
        final Cyclist savedCyclist = cyclistRepository.save(mapperCyclist);
        return cyclistMapper.toDto(savedCyclist);
    }

    @Override
    public CyclistResponseDTO update(Long id, CyclistRequestDTO cyclistRequestDTO) {
        try {
            Optional<Cyclist> existingCyclistOpt = cyclistRepository.findById(id);
            if (existingCyclistOpt.isEmpty()) {
                throw new EntityNotFoundException("Cyclist with ID " + id + " not found.");
            }

            Cyclist existingCyclist = existingCyclistOpt.get();
            existingCyclist.setName(cyclistRequestDTO.name());
            existingCyclist.setAge(cyclistRequestDTO.age());
            existingCyclist.setNationality(cyclistRequestDTO.nationality());

            Team team = teamRepository.findById(cyclistRequestDTO.teamId()).orElseThrow(() -> new EntityNotFoundException("Team with ID " + cyclistRequestDTO.teamId() + " not found."));

            existingCyclist.setTeam(team);

            Cyclist updatedCyclist = cyclistRepository.save(existingCyclist);
            return cyclistMapper.toDto(updatedCyclist);
        } catch (DataIntegrityViolationException e) {
            throw new ValidationException("Data integrity violation: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage());
        }
    }
    @Override
    public void delete(Long id) {
        cyclistRepository.deleteById(id);
    }

    public List<CyclistResponseDTO> getCyclistsSortedByName() {
        return cyclistRepository.findAll().stream()
                .sorted(Comparator.comparing(Cyclist::getName))
                .map(cyclistMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CyclistResponseDTO> getCyclistsSortedByNationality() {
        return cyclistRepository.findAll().stream()
                .sorted(Comparator.comparing(Cyclist::getNationality))
                .map(cyclistMapper::toDto)
                .collect(Collectors.toList());
    }
}
