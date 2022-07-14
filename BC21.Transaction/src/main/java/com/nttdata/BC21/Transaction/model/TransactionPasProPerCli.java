package com.nttdata.BC21.Transaction.model;

import com.nttdata.BC21.Transaction.model.responseWC.PasProPerCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TransactionPasProPerCli extends BaseModel{
    //private  String code;
    private String idPasProPerCli;
    private PasProPerCli pasProPerCli;
    private LocalDateTime transactionDate;
    private String transactionTypePasPro;
    private double amount;
}
