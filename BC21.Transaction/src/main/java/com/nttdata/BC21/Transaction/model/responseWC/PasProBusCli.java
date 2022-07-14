package com.nttdata.BC21.Transaction.model.responseWC;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class PasProBusCli extends BaseModel{
    //private String code;
    private double amount;
    private String accountNumber;
    private LocalDateTime openingDate;
    private String idBusinessClient;
    private String idPasiveProduct;
    private BusinessClient businessClient;
    private PasiveProduct pasiveProduct;
    //private boolean state;
}
