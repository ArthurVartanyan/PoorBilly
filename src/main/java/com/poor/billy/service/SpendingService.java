package com.poor.billy.service;

import com.poor.billy.dto.SpendingDTO;
import com.poor.billy.exceptions.EntityNotFoundException;
import com.poor.billy.mapper.SpendingMapper;
import com.poor.billy.mapper.UserMapper;
import com.poor.billy.model.operation.Spending;
import com.poor.billy.model.user.User;
import com.poor.billy.repository.SpendingRepository;
import com.poor.billy.security.jwt.JWTUser;
import com.poor.billy.specification.OperationSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        spending.setDeleted(false);
        spending.setUser(userMapper.map(JWTUser.getCurrentUser(), User.class));
        return spendingMapper.map(spendingRepository.save(spending), SpendingDTO.class);
    }

    /**
     * Method for delete spending recording in stat
     *
     * @param id - spending ID
     */
    public void deleteIncome(Long id) {
        Spending spending = spendingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Spending with id:" + id + "is not exists"));
        spending.setDeleted(true);
        spendingRepository.save(spending);
    }

    public SpendingDTO editSpending(Long id, SpendingDTO spendingDTO) {
        Spending spending = spendingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Spending with id:" + id + "is not exists"));

        spending.setType(spendingDTO.getType());
        spending.setSum(spendingDTO.getSum());
        spending.setTransactionDate(spendingDTO.getTransactionDate());
        return spendingMapper.map(spendingRepository.save(spending), SpendingDTO.class);
    }

    /**
     * Find all current user spending list
     *
     * @return - SpendingList DTO
     */
    public List<SpendingDTO> findAllSpending() {
        List<Spending> spendingList = spendingRepository.findAllByUserIdAndDeletedIsFalse(JWTUser.getCurrentUserID());
        return spendingMapper.mapAsList(spendingList, SpendingDTO.class);
    }

    /**
     * Find all spending with date filter
     *
     * @param fromDay - Countdown from which day
     * @param toDay   - Countdown to what day
     * @return - list of spending DTOs
     */
    public List<SpendingDTO> findAllByFilter(Date fromDay, Date toDay) {
        List<Spending> spendingList = spendingRepository
                .findAll(OperationSpecification.betweenSpendingDate(JWTUser.getCurrentUserID(), fromDay, toDay));
        return spendingMapper.mapAsList(spendingList, SpendingDTO.class);
    }
}