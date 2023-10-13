package com.project.crystalBall.controller;


import com.project.crystalBall.config.securityConfig.UserAuthenticationProvider;
import com.project.crystalBall.dto.User.User;
import com.project.crystalBall.service.impl.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    UserAuthenticationProvider userAuthenticationProvider;


    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<User> create(@RequestBody User userRequest){
        User user = userService.create(userRequest);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-token",userAuthenticationProvider.createToken(user));
        user.setPassword(null);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(responseHeaders)
                .body(null);
    }

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestBody User userRequest){
        User user = userService.readByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-token",userAuthenticationProvider.createToken(user));
        user.setPassword(null);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(responseHeaders)
                .body(null);
    }

}

