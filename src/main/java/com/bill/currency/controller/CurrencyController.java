package com.bill.currency.controller;

import com.bill.currency.dto.CurrencyResponseDto;
import com.bill.currency.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/rate")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public CurrencyResponseDto currencyRateResponse() {
        return currencyService.getRateAndOverallRange();
    }
}

