package com.parkjonghun.springboot.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hello")
    String hello() {
        return "hello";
    }

    @GetMapping("/bye")
    String bye(Model model) {
        model.addAttribute("name", "Park JongHun");
        return "bye";
    }
}
