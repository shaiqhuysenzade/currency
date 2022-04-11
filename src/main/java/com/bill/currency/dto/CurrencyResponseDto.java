package com.bill.currency.dto;

import com.bill.currency.util.BigDecimalSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class CurrencyResponseDto {
    @JsonSerialize(using = BigDecimalSerialize.class)
    private BigDecimal initialRate;
    @JsonSerialize(using = BigDecimalSerialize.class)
    private BigDecimal overageRate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
}
