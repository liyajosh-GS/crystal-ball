package com.project.crystalball.controller;


import com.project.crystalball.config.UserAuthenticationProvider;
import com.project.crystalball.dto.User.User;
import com.project.crystalball.dto.contribution.Contribution;
import com.project.crystalball.service.impl.User.UserService;
import com.project.crystalball.service.impl.contribution.ContributionService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity create(@RequestBody User userRequest){
        User user = userService.create(userRequest);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("token",userAuthenticationProvider.createToken(user));
        user.setPassword(null);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(responseHeaders)
                .body(user);
    }

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody User userRequest){
        User user = userService.readByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-token",userAuthenticationProvider.createToken(user));
        user.setPassword(null);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(responseHeaders)
                .body(user);
    }

}

