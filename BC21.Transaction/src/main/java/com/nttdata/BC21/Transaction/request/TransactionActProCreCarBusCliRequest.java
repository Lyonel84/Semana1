package com.nttdata.BC21.Transaction.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionActProCreCarBusCliRequest {
    private String idActProCreCarBusCli;
    private double amount;
    private String transactionTypeActPro;
}
