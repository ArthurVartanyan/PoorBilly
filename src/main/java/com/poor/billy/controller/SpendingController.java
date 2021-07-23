package com.poor.billy.controller;

import com.poor.billy.dto.SpendingDTO;
import com.poor.billy.exceptions.EntityNotFoundException;
import com.poor.billy.model.user.User;
import com.poor.billy.repository.SpendingRepository;
import com.poor.billy.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/spending")
public class SpendingController {

    private SpendingService spendingService;

    private SpendingRepository spendingRepository;

    @Autowired
    public void setSpendingRepository(SpendingRepository spendingRepository) {
        this.spendingRepository = spendingRepository;
    }

    @Autowired
    public void setSpendingService(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @GetMapping("/all")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<List<SpendingDTO>> findAllCurrentUserSpending() {
        return new ResponseEntity<>(spendingService.findAllSpending(), HttpStatus.OK);
    }

    @PostMapping("/new")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<SpendingDTO> createSpending(@Valid @RequestBody SpendingDTO spendingDTO) {
        return new ResponseEntity<>(spendingService.createSpending(spendingDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{spendingId}")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<Void> deleteSpending(@PathVariable Long spendingId) {
        if (spendingRepository.existsById(spendingId)) {
            spendingService.deleteIncome(spendingId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else throw new EntityNotFoundException("Spending with id: " + spendingId + " is not exists");
    }

    @PutMapping("/{spendingId}")
    @RolesAllowed(User.FINANCIER)
    public ResponseEntity<SpendingDTO> editSpending(@PathVariable Long spendingId,
                                                    @Valid @RequestBody SpendingDTO spendingDTO) {
        if (spendingRepository.existsById(spendingId)) {
            return new ResponseEntity<>(spendingService.editSpending(spendingId, spendingDTO), HttpStatus.OK);
        } else throw new EntityNotFoundException("Spending with id: " + spendingId + " is not exists");
    }
}