package com.project.crystalBall.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csrf")
@CrossOrigin(maxAge = 3600)
public class CsrfController {

    @GetMapping
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }

}
