package com.poor.billy.controller;

import com.poor.billy.dto.SpendingDTO;
import com.poor.billy.model.user.User;
import com.poor.billy.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/spending")
public class SpendingController {

    private SpendingService spendingService;

    @Autowired
    public void setSpendingService(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @PostMapping("/new")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<SpendingDTO> createSpending(@Valid @RequestBody SpendingDTO spendingDTO) {
        return new ResponseEntity<>(spendingService.createSpending(spendingDTO), HttpStatus.OK);
    }
}