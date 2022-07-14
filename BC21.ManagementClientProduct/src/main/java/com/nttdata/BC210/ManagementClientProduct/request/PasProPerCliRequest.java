package com.nttdata.BC210.ManagementClientProduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PasProPerCliRequest {
    private double amount;
    private String idPersonClient;
    private String idPasiveProduct;

}
