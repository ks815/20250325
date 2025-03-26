package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class JHU {

    private int size;

    private String students;

    private int ranking;

    private double male;

    //@JsonProperty("Female")
    private double female;
}
