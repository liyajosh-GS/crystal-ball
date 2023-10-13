package com.project.crystalBall.controller;

import com.project.crystalBall.dto.User.User;
import com.project.crystalBall.dto.bankDetails.BankDetails;
import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.service.impl.bankDetails.BankService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankDetailsController {

    @Autowired
    BankService bankService;

    @PostMapping
    public ResponseEntity<BankDetails> create(@RequestBody @Valid BankDetails bankDetails){
        bankService.create(bankDetails);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(null);
    }
}
