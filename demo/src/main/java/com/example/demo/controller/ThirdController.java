package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("test2")
public class ThirdController {
    @GetMapping("/untethered")
    public String get (@RequestParam(value = "love", defaultValue="") String modest) {
        return "Occult encomium " + modest;
    }

    @PostMapping("/omnipresent")
    @ResponseBody
    public String remedy(@RequestBody Utilization enamor) {
        return "It's pecuniary because " + enamor.getParsimonious();
    }
}
