package com.youcode.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cyclists")
public class CyclistController {

    @GetMapping("/all")
    public List<String> getAllCyclists() {
        return Arrays.asList("Mark Cavendish", "Tadej Pogačar", "Egan Bernal", "Peter Sagan");
    }
}
