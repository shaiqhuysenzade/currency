package com.bill.currency.restclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rates {
    @JsonProperty("UAH")
    private float uah;

}

