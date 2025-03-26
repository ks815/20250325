package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("test")
public class SecondController {

    @GetMapping("/id/{id}")
    public String getUserById(@PathVariable(value = "id", required = false) String id) {
        return "id " + id;
    }

    @PostMapping("/dubious")
    @ResponseBody
    public String dubious(@RequestBody Serendipity perilous) {
        return "This is so " + perilous.getClandestine();
    }

    @PostMapping("/dubious2")
    @ResponseBody
    public String dubious2 (@RequestBody Serendipity perilous) {
        return "The time spent on doing dispatch is " + perilous.getDispatch();
    }
}
