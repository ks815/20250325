package com.example.demo.controller;

import com.example.demo.manager.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("test")
public class FirstController {

    @Resource
    private JDBCSelect jdbc;
    @Resource
    private JDBCInsert jdbc2;
    @Resource
    private JDBCDelete jdbc3;
    @Resource
    private JDBCUpdate jdbc4;

    @Resource
    private JDBCRelationshipSelec jdbcRelationshipSelec;

    @GetMapping("/get")
    public String get (@RequestParam(value = "id", defaultValue="") String ck) {
        String name = jdbc.jdbcProgram(ck);
        return "hello world :" + name;
    }

    @GetMapping("/getClas")
    public List<clas> getClas (@RequestParam(value = "id", defaultValue="") String ck) {
        List<clas> cla = jdbcRelationshipSelec.jdbcProgramClas(ck);
        return cla;
    }

    @GetMapping("/getStud")
    public List<Obje> getStud (@RequestParam(value = "id", defaultValue="") String ck) {
        List<Obje> stu = jdbcRelationshipSelec.jdbcProgram(ck);
        return stu;
    }


    @PostMapping("/add")
    @ResponseBody
    public String add (@RequestBody Obje obje) {
        return jdbc2.jdbcProgram(obje);
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete (@RequestBody Obje obje) {
        return jdbc3.jdbcProgram(obje);
    }

    @PostMapping("/update")
    @ResponseBody
    public String update (@RequestBody Obje obje) {
        return jdbc4.jdbcProgram(obje);
    }

    
}
