package com.nttdata.BC21.Transaction.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionActProCreCarPerCliRequest {
    private String idActProCreCarPerCli;
    private double amount;
    private String transactionTypeActPro;
}
