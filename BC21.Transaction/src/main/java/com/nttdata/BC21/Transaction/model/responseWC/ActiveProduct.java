package com.nttdata.BC21.Transaction.model.responseWC;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActiveProduct {
    private String id;
    private String name;
    private double interestRateMonth;
    private Boolean allowBusinessClient;
    private Boolean allowPersonClient;
}
