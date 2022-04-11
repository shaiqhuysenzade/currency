package com.bill.currency.cron;

import com.bill.currency.entity.AverageRate;
import com.bill.currency.entity.Currency;
import com.bill.currency.repository.AverageRateRepository;
import com.bill.currency.repository.CurrencyRepository;
import com.bill.currency.restclient.CurrencyRateRestClient;
import com.bill.currency.restclient.response.RateRestClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CurrencyCron {
    private final CurrencyRateRestClient currencyRateRestClient;
    private final CurrencyRepository currencyRepository;
    private final AverageRateRepository averageRateRepository;

    @Scheduled(fixedRate = 30000)
    public void process() {
        Optional<AverageRate> byId = averageRateRepository.findFirstByOrderById();
        if (byId.isPresent()) {
            RateRestClientResponse rate = currencyRateRestClient.getRate();
            Currency currency = new Currency();
            currency.setRateTime(LocalDateTime.now());
            currency.setRate((double) rate.getRates().getUah());
            currencyRepository.saveAndFlush(currency);

            AverageRate averageRate = byId.get();
            Double average = averageRate.getInitialRate();
            double a = (average + currency.getRate()) / 2;
            averageRate.setAverage(a);
            averageRateRepository.save(averageRate);
        }
    }
}
