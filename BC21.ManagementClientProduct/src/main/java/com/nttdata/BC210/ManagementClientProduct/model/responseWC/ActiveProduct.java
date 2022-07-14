package com.nttdata.BC210.ManagementClientProduct.model.responseWC;

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
