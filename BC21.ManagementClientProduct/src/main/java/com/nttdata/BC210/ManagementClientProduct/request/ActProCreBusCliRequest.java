package com.nttdata.BC210.ManagementClientProduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActProCreBusCliRequest {
    private double amountGiven;
    private double interestRate;
    private String idBusinessClient;
    private String idActiveProduct;
}
