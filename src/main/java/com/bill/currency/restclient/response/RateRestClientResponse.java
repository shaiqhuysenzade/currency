package com.bill.currency.restclient.response;

import lombok.Data;

@Data
public class RateRestClientResponse {
    Motd motd;
    private boolean success;
    private String base;
    private String date;
    Rates rates;
}