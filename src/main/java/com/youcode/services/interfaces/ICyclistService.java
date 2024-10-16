package com.youcode.services.interfaces;

import com.youcode.entities.Cyclist;

import java.util.List;

public interface ICyclistService {
    List<Cyclist> getAllCyclists();

    Cyclist getCyclistById(Long id);

    Cyclist saveCyclist(Cyclist cyclist);

    void deleteCyclist(Long id);
}
