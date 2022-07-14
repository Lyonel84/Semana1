package com.nttdata.BC21.Transaction.model;

import com.nttdata.BC21.Transaction.model.responseWC.ActProCreBusCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TransactionActProCreBusCli extends BaseModel{
    //private  String code;
    private LocalDateTime transactionDate;
    private String idActProCreBusCli;
    private ActProCreBusCli actProCreBusCli;
    private String transactionTypeActPro;
    private double amount;
}
