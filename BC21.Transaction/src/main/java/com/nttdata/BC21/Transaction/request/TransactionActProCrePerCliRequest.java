package com.nttdata.BC21.Transaction.request;

import lombok.Data;

@Data
public class TransactionActProCrePerCliRequest {
    private String idActProCrePerCli;
    private double amount;
    private String transactionTypeActPro;
}
