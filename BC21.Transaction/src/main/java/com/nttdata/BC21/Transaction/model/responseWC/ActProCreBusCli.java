package com.nttdata.BC21.Transaction.model.responseWC;

import lombok.Data;

@Data
public class ActProCreBusCli extends BaseModel{
    private double amountGiven;
    private double amountPaid;
    private double interestRate;
    private String idBusinessClient;
    private String idActiveProduct;
    private BusinessClient businessClient;
    private ActiveProduct activeProduct;
}
