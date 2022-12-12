package com.tp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
    // Q 1
    @GetMapping("/greeting1")
    @ResponseBody
    public String greeting1(@RequestParam(name = "to", defaultValue = "Word", required = false) String to) {
        return "Hello " + to;
    }

    // Q 2
    @GetMapping("/greeting2")
    @ResponseBody
    public String greeting2(@RequestParam(name = "who", defaultValue = "Word", required = false) String who,
            @RequestParam(name = "ent", defaultValue = "ESME", required = false) String ent) {
        return "Hello " + who + " ! Welcome to " + ent;

    }

}