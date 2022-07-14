package com.nttdata.BC21.Transaction.model;

import com.nttdata.BC21.Transaction.model.responseWC.ActProCrePerCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TransactionActProCrePerCli extends BaseModel{
    //private  String code;
    private LocalDateTime transactionDate;
    private String idActProCrePerCli;
    private ActProCrePerCli actProCrePerCli;
    private String transactionTypeActPro;
    private double amount;
}
