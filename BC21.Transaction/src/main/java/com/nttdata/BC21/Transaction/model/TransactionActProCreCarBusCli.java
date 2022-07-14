package com.nttdata.BC21.Transaction.model;

import com.nttdata.BC21.Transaction.model.responseWC.ActProCreCarBusCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class TransactionActProCreCarBusCli extends BaseModel{
    //private  String code;
    private LocalDateTime transactionDate;
    private String idActProCreCarBusCli;
    private ActProCreCarBusCli actProCreCarBusCli;
    private String transactionTypeActPro;
    private double amount;
}
