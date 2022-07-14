package com.nttdata.BC21.Transaction.model.responseWC;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ActProCrePerCli extends BaseModel{
    private double amountGiven;
    private double amountPaid;
    private double interestRate;
    private String idPersonClient;
    private String idActiveProduct;
    private PersonClient personClient;
    private ActiveProduct activeProduct;
}
