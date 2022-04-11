package com.bill.currency.restclient;

import com.bill.currency.restclient.response.RateRestClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CurrencyRateRestClient {
    private final RestTemplate restTemplate;

    public RateRestClientResponse getRate() {
        return restTemplate.getForObject(
                "https://api.exchangerate.host/latest?base=USD&symbols=UAH",
                RateRestClientResponse.class);
    }
}
