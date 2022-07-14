package com.nttdata.BC21.Transaction.exception;

public class PasProBusCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "PASIVE PRODUCT BUSINESS CLIEN NOT FOUND";

    public PasProBusCliNotFoundException(){
        super(MESSAGE);
    }
}
