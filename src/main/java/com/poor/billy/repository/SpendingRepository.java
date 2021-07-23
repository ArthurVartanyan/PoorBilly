package com.poor.billy.repository;

import com.poor.billy.model.operation.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpendingRepository extends JpaRepository<Spending, Long> {

    List<Spending> findAllByUserIdAndDeletedIsFalse(Long userId);
}