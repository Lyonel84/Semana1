package com.nttdata.BC21.Transaction.model;

import com.nttdata.BC21.Transaction.model.responseWC.PasProBusCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TransactionPasProBusCli extends BaseModel{
    //private  String code;
    private String idPasProBusCli;
    private PasProBusCli pasProBusCli;
    private LocalDateTime transactionDate;
    private String transactionTypePasPro;
    private double amount;
}
