package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceQuixotic {
    private Unremitting unceasing;

    @Autowired
    public void setUnremitting(Unremitting unstoppable) {
        this.unceasing = unstoppable;
    }

    @PostConstruct
    public void init() {
        System.out.println("It is idealistic to have number " + Unremitting.eternity());
    }
}
