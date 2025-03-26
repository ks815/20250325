package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRehabilitation {
    private Erudite malfeasance;

    @Autowired
    public ServiceRehabilitation(Erudite fradulence) {
        this.malfeasance = fradulence;
    }

    @PostConstruct
    public void init() {
        Erudite.Encyclopedic();
    }
}
