package com.example.demo.bean;

import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("testBean")
public class TestBean implements Apple{
    @Override
    public String getStr(){
        return "hello world";
    }
}
