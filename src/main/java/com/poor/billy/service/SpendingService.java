package com.poor.billy.service;

import com.poor.billy.dto.SpendingDTO;
import com.poor.billy.dto.SpendingDTO;
import com.poor.billy.mapper.SpendingMapper;
import com.poor.billy.mapper.UserMapper;
import com.poor.billy.model.operation.Spending;
import com.poor.billy.model.user.User;
import com.poor.billy.repository.SpendingRepository;
import com.poor.billy.security.jwt.JWTUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpendingService {

    private SpendingRepository spendingRepository;

    private SpendingMapper spendingMapper;

    private UserMapper userMapper;

    @Autowired
    public void setSpendingRepository(SpendingRepository spendingRepository) {
        this.spendingRepository = spendingRepository;
    }

    @Autowired
    public void setSpendingMapper(SpendingMapper spendingMapper) {
        this.spendingMapper = spendingMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * Method add new spending money
     *
     * @param spendingDTO - data transfer object for Spending class
     * @return - saved spending and mapped spendingDTO
     */
    public SpendingDTO createSpending(SpendingDTO spendingDTO) {
        Spending spending = spendingMapper.map(spendingDTO, Spending.class);
        spending.setUser(userMapper.map(JWTUser.getCurrentUser(), User.class));
        return spendingMapper.map(spendingRepository.save(spending), SpendingDTO.class);
    }
}