package com.nttdata.BC210.ManagementClientProduct.model;

import com.nttdata.BC210.ManagementClientProduct.model.responseWC.ActiveProduct;
import com.nttdata.BC210.ManagementClientProduct.model.responseWC.PersonClient;
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
