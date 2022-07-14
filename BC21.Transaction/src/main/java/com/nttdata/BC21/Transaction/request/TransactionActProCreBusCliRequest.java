package com.nttdata.BC21.Transaction.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionActProCreBusCliRequest {
    private String idActProCreBusCli;
    private double amount;
    private String transactionTypeActPro;
}
