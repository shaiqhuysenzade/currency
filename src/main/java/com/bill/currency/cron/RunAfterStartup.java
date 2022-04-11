package com.bill.currency.cron;

import com.bill.currency.entity.AverageRate;
import com.bill.currency.entity.Currency;
import com.bill.currency.repository.AverageRateRepository;
import com.bill.currency.repository.CurrencyRepository;
import com.bill.currency.restclient.CurrencyRateRestClient;
import com.bill.currency.restclient.response.RateRestClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class RunAfterStartup {
    private final CurrencyRateRestClient restClient;
    private final CurrencyRepository currencyRepository;
    private final AverageRateRepository averageRateRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        RateRestClientResponse rate = restClient.getRate();
        double initialRate = rate.getRates().getUah();
        fillCurrency(initialRate);
        fillAverageRate(initialRate);

    }

    @Transactional
    public void fillCurrency(double rate) {
        Currency currency = new Currency();
        currency.setRate(rate);
        currency.setRateTime(LocalDateTime.now());
        currencyRepository.save(currency);
    }

    @Transactional
    public void fillAverageRate(double rate) {
        AverageRate averageRate = new AverageRate();
        averageRate.setAverage(rate);
        averageRate.setInitialRate(rate);
        averageRateRepository.save(averageRate);
    }
}
