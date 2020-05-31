package com.reactive.smartparking.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    private ResponseEntity<String> homePage() {
        return ResponseEntity.ok().body("Welcome to reactive smartparking-api");
    }
}
