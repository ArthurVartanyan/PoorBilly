package com.poor.billy.controller;

import com.poor.billy.dto.IncomeDTO;
import com.poor.billy.exceptions.EntityNotFoundException;
import com.poor.billy.model.user.User;
import com.poor.billy.repository.IncomeRepository;
import com.poor.billy.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private IncomeService incomeService;

    private IncomeRepository incomeRepository;

    @Autowired
    public void setIncomeRepository(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Autowired
    public void setIncomeService(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/all")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<List<IncomeDTO>> findAllCurrentUserIncomes() {
        return new ResponseEntity<>(incomeService.findAllIncome(), HttpStatus.OK);
    }

    @PostMapping("/new")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<IncomeDTO> createIncome(@Valid @RequestBody IncomeDTO incomeDTO) {
        return new ResponseEntity<>(incomeService.createIncome(incomeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{incomeId}")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<Void> deleteIncome(@PathVariable Long incomeId) {
        if (incomeRepository.existsById(incomeId)) {
            incomeService.deleteIncome(incomeId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else throw new EntityNotFoundException("Income with id: " + incomeId + " is not exists");
    }

    @PutMapping("/{incomeId}")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<IncomeDTO> editIncome(@PathVariable Long incomeId,
                                                @Valid @RequestBody IncomeDTO incomeDTO) {
        if (incomeRepository.existsById(incomeId)) {
            return new ResponseEntity<>(incomeService.editIncome(incomeId, incomeDTO), HttpStatus.OK);
        } else throw new EntityNotFoundException("Income with id: " + incomeId + " is not exists");
    }
}