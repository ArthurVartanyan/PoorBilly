package com.poor.billy.service;

import com.poor.billy.dto.IncomeDTO;
import com.poor.billy.exceptions.EntityNotFoundException;
import com.poor.billy.mapper.IncomeMapper;
import com.poor.billy.mapper.UserMapper;
import com.poor.billy.model.operation.Income;
import com.poor.billy.model.user.User;
import com.poor.billy.repository.IncomeRepository;
import com.poor.billy.security.jwt.JWTUser;
import com.poor.billy.specification.OperationSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IncomeService {

    private IncomeRepository incomeRepository;

    private IncomeMapper incomeMapper;

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setIncomeMapper(IncomeMapper incomeMapper) {
        this.incomeMapper = incomeMapper;
    }

    @Autowired
    public void setIncomeRepository(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    /**
     * Method add new income money
     *
     * @param incomeDTO - data transfer object for Income class
     * @return - saved income and mapped incomeDTO
     */
    public IncomeDTO createIncome(IncomeDTO incomeDTO) {
        Income income = incomeMapper.map(incomeDTO, Income.class);
        income.setDeleted(false);
        income.setUser(userMapper.map(JWTUser.getCurrentUser(), User.class));
        return incomeMapper.map(incomeRepository.save(income), IncomeDTO.class);
    }

    /**
     * Method for delete income recording in stat
     *
     * @param id - income ID
     */
    public void deleteIncome(Long id) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Income with id:" + id + "is not exists"));
        income.setDeleted(true);
        incomeRepository.save(income);
    }

    /**
     * Method for edit income operation
     *
     * @param id        - income ID
     * @param incomeDTO - edited Income
     * @return - edited Income
     */
    public IncomeDTO editIncome(Long id, IncomeDTO incomeDTO) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Spending with id:" + id + "is not exists"));

        income.setType(incomeDTO.getType());
        income.setSum(incomeDTO.getSum());
        income.setTransactionDate(incomeDTO.getTransactionDate());
        return incomeMapper.map(incomeRepository.save(income), IncomeDTO.class);
    }

    /**
     * Find all current user incomes
     *
     * @return - Incomes DTO
     */
    public List<IncomeDTO> findAllIncome() {
        List<Income> incomes = incomeRepository.findAllByUserIdAndDeletedIsFalse(JWTUser.getCurrentUserID());
        return incomeMapper.mapAsList(incomes, IncomeDTO.class);
    }

    /**
     * Find all incomes with date filter
     *
     * @param fromDay - Countdown from which day
     * @param toDay   - Countdown to what day
     * @return - list of income DTOs
     */
    public List<IncomeDTO> findAllByDate(Date fromDay, Date toDay) {
        List<Income> incomes = incomeRepository
                .findAll(OperationSpecification.betweenIncomeDate(JWTUser.getCurrentUserID(), fromDay, toDay));
        return incomeMapper.mapAsList(incomes, IncomeDTO.class);
    }
}