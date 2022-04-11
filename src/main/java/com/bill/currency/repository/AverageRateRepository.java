package com.bill.currency.repository;

import com.bill.currency.entity.AverageRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AverageRateRepository extends JpaRepository<AverageRate, Long> {
    Optional<AverageRate> findFirstByOrderById();
}
