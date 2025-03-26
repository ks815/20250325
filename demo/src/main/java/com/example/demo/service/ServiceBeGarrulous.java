package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBeGarrulous {
    private Taciturn introvert;

    @Autowired
    public void setTaciturn(Taciturn surly) {
        this.introvert = surly;
    }

    @PostConstruct
    public void init() {
        Taciturn.curt();
    }
}
