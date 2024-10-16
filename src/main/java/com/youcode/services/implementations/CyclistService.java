package com.youcode.services.implementations;

import com.youcode.entities.Cyclist;
import com.youcode.repositories.CyclistRepository;
import com.youcode.services.interfaces.ICyclistService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CyclistService implements ICyclistService {

    private final CyclistRepository cyclistRepository;

    public CyclistService(CyclistRepository cyclistRepository) {
        this.cyclistRepository = cyclistRepository;
    }

    @Override
    public List<Cyclist> getAllCyclists() {
        return List.of();
    }

    @Override
    public Cyclist getCyclistById(Long id) {
        return null;
    }

    @Override
    public Cyclist saveCyclist(Cyclist cyclist) {
        cyclistRepository.save(cyclist);
        return cyclist;
    }

    @Override
    public void deleteCyclist(Long id) {

    }
}
