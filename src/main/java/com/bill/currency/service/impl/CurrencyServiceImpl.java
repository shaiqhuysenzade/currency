package com.bill.currency.service.impl;

import com.bill.currency.dto.CurrencyResponseDto;
import com.bill.currency.entity.AverageRate;
import com.bill.currency.repository.AverageRateRepository;
import com.bill.currency.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final AverageRateRepository averageRateRepository;

    @Override
    public CurrencyResponseDto getRateAndOverallRange() {
        return averageRateRepository.findFirstByOrderById()
                .map(this::map)
                .orElseThrow(() -> new IllegalArgumentException("Something goes wrong"));
    }

    private CurrencyResponseDto map(AverageRate averageRate) {
        return CurrencyResponseDto.builder()
                .initialRate(BigDecimal.valueOf(averageRate.getInitialRate()))
                .overageRate(BigDecimal.valueOf(averageRate.getAverage()))
                .localDateTime(LocalDateTime.now())
                .build();
    }
}
