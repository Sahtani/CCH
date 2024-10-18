package com.youcode.services.implementations;

import com.youcode.entities.Cyclist;
import com.youcode.repositories.CyclistRepository;
import com.youcode.services.api.CyclistService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CyclistServiceImpl implements CyclistService {

    private final CyclistRepository cyclistRepository;
    private List<Cyclist> cyclists;
    public CyclistServiceImpl(CyclistRepository cyclistRepository) {
        this.cyclistRepository = cyclistRepository;
    }

    @Override
    public List<Cyclist> getAll() {
        return cyclistRepository.findAll();
    }

    @Override
    public Optional<Cyclist> getById(Long id) {
        return Optional.ofNullable(cyclistRepository.findById(id).orElse(null));
    }

    @Override
    public Cyclist save(Cyclist cyclist) {
        return cyclistRepository.save(cyclist);
    }

    public Cyclist update(Cyclist cyclist) {

        if (!cyclistRepository.existsById(cyclist.getId())) {
            throw new IllegalArgumentException("Cyclist not found.");
        }
        return cyclistRepository.save(cyclist);
    }

    @Override
    public void delete(Long id) {
        cyclistRepository.deleteById(id);
    }
    public List<Cyclist> getCyclistsSortedByName() {
        List<Cyclist> cyclists = cyclistRepository.findAll();
        List<Cyclist> sortedCyclists = new ArrayList<>(cyclists);
        sortedCyclists.sort(Comparator.comparing(Cyclist::getLastName));
        return sortedCyclists;
    }

    public List<Cyclist> getCyclistsSortedByNationality() {
        List<Cyclist> sortedCyclists = new ArrayList<>(cyclists);
        sortedCyclists.sort(Comparator.comparing(Cyclist::getNationality));
        return sortedCyclists;
    }

//    public List<Cyclist> getCyclistsSortedByTeam() {
//        List<Cyclist> sortedCyclists = new ArrayList<>(cyclists);
//        sortedCyclists.sort(Comparator.comparing(Cyclist::getTeam));
//        return sortedCyclists;
//    }
}
