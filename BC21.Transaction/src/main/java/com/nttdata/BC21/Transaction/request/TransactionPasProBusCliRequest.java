package com.nttdata.BC21.Transaction.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionPasProBusCliRequest {
    private String idPasProBusCli;
    private double amount;
    private String transactionTypePasPro;
}
