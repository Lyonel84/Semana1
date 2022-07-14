package com.nttdata.BC210.ManagementClientProduct.model;

import com.nttdata.BC210.ManagementClientProduct.model.responseWC.PasiveProduct;
import com.nttdata.BC210.ManagementClientProduct.model.responseWC.PersonClient;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class PasProPerCli extends BaseModel{

    //private String code;
    private double amount;
    private String accountNumber;
    private LocalDateTime openingDate;
    private String idPersonClient;
    private String idPasiveProduct;
    private PersonClient personClient;
    private PasiveProduct pasiveProduct;
    //private boolean state;

}
