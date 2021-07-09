package com.poor.billy.service;

import com.poor.billy.dto.IncomeDTO;
import com.poor.billy.mapper.IncomeMapper;
import com.poor.billy.mapper.UserMapper;
import com.poor.billy.model.operation.Income;
import com.poor.billy.model.user.User;
import com.poor.billy.repository.IncomeRepository;
import com.poor.billy.security.jwt.JWTUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public IncomeDTO createIncome(IncomeDTO incomeDTO) {
        Income income = incomeMapper.map(incomeDTO, Income.class);
        income.setUser(userMapper.map(JWTUser.getCurrentUser(), User.class));
        return incomeMapper.map(incomeRepository.save(income), IncomeDTO.class);
    }
}