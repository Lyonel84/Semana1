package com.nttdata.BC210.ManagementClientProduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActProCreCarPerCliRequest {
    private double creditLine;
    private int AnnualCommission;
    private int cutoffDate;
    private int payLimitDate;
    private String idPersonClient;
    private String idActiveProduct;
}
