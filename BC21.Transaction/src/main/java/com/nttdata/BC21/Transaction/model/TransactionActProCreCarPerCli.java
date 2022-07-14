package com.nttdata.BC21.Transaction.model;

import com.nttdata.BC21.Transaction.model.responseWC.ActProCreCarPerCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TransactionActProCreCarPerCli extends BaseModel{
    //private  String code;
    private LocalDateTime transactionDate;
    private String idActProCreCarPerCli;
    private ActProCreCarPerCli actProCreCarPerCli;
    private String transactionTypeActPro;
    private double amount;
}
