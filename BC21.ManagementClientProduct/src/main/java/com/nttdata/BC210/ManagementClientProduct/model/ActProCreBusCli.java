package com.nttdata.BC210.ManagementClientProduct.model;

import com.nttdata.BC210.ManagementClientProduct.model.responseWC.ActiveProduct;
import com.nttdata.BC210.ManagementClientProduct.model.responseWC.BusinessClient;
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
