package com.nttdata.BC21.PassiveProduct.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassiveProduct extends BaseModel {
    private String name;
    private double maintenanceCommission;
    private double transactionCommission;
    private double minimumOpeningAmount;
    private int numLimitMovements;
    private int dayMovement;
    private Boolean allowBusinessClient;
    private Boolean allowPersonClient;
}