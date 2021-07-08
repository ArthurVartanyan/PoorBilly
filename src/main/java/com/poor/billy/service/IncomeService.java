package com.poor.billy.service;

import com.poor.billy.dto.IncomeDTO;
import com.poor.billy.model.operation.Income;
import com.poor.billy.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {

    private IncomeRepository incomeRepository;

    @Autowired
    public void setIncomeRepository(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

//    public IncomeDTO createIncome(IncomeDTO incomeDTO) {
//
//    }
}