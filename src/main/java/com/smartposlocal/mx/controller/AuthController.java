package com.smartposlocal.mx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartposlocal.mx.dto.AuthRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody AuthRequest authRequest) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
