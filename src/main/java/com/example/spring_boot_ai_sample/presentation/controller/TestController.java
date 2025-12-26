package com.example.spring_boot_ai_sample.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ai_sample.utility.calculator.CircleUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class TestController {
    
    @PostMapping("/circle_area")
    public ResponseEntity<Double> calculateCircleArea(double radius) {
        double area = CircleUtils.calculateCircleArea(radius);
        return ResponseEntity.ok(area);
    }
}
