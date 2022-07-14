package com.nttdata.BC210.ManagementClientProduct.model;

import com.nttdata.BC210.ManagementClientProduct.model.responseWC.BusinessClient;
import com.nttdata.BC210.ManagementClientProduct.model.responseWC.PasiveProduct;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<String> holders;
    private List<String> signers;
    //private boolean state;
}
