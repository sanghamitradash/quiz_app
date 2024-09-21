package com.example.quizapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestC {

    @GetMapping("/test")
    public String testPage() {
        return "test"; // This should map to test.html
    }

}
