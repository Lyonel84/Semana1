package com.nttdata.BC210.ManagementClientProduct.request;

import lombok.Data;

import java.util.List;

@Data
public class PasProBusCliRequest {
    private double amount;
    private String idBusinessClient;
    private String idPasiveProduct;
    private List<String> holders;
    private List<String> signers;
}
