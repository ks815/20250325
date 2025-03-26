package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUnpredictable {
    @Autowired
    private Versatile omnipresent;

    @PostConstruct
    public void init() {
        Versatile.Capricious();
    }
}
