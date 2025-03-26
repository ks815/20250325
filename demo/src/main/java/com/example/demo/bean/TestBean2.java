package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component("testBean2")
public class TestBean2 implements Apple {
    @Override
    public String getStr() {
        return "Excellent";
    }
}
