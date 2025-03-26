package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
public class Users {
    private int StudentID;
    private String StudentLName;
    private String StudentFName;
    private int StudentRank;
    private int StudentNumber;
    private String StudentAddress;
    private String City;
}
