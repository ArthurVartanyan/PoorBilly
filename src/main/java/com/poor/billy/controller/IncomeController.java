package com.poor.billy.controller;

import com.poor.billy.dto.IncomeDTO;
import com.poor.billy.model.user.Role;
import com.poor.billy.model.user.User;
import com.poor.billy.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/api/income")
public class IncomeController {

    private IncomeService incomeService;

    @Autowired
    public void setIncomeService(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping("/new")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<IncomeDTO> createIncome(@RequestBody IncomeDTO incomeDTO) {
        return new ResponseEntity<>(incomeService.createIncome(incomeDTO), HttpStatus.OK);
    }
}