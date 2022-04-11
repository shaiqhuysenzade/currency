package com.bill.currency.service;

import com.bill.currency.dto.CurrencyResponseDto;

public interface CurrencyService {

    CurrencyResponseDto getRateAndOverallRange();
}
