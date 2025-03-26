package com.example.demo.service;

import com.example.demo.bean.Apple;
import com.example.demo.bean.TestBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private Apple testBean;
    //@Qualifier

    @Autowired
    public void setApple(Apple testBean) {
        this.testBean = testBean;
    }

    @PostConstruct //
    public void init(){
        System.out.println("testBean3.getStr() = " + testBean.getStr());
    }


}
