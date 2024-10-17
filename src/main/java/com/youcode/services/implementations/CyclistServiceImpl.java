package com.youcode.services.implementations;

import com.youcode.entities.Cyclist;
import com.youcode.repositories.CyclistRepository;
import com.youcode.services.api.CyclistService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CyclistServiceImpl implements CyclistService {

    private final CyclistRepository cyclistRepository;

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

    @Override
    public void delete(Long id) {
        cyclistRepository.deleteById(id);
    }
}
