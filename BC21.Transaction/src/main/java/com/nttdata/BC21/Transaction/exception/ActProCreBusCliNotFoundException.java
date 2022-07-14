package com.nttdata.BC21.Transaction.exception;

public class ActProCreBusCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "ACTIVE PRODUCT CREDIT BUSINESS CLIEN NOT FOUND";

    public ActProCreBusCliNotFoundException(){
        super(MESSAGE);
    }
}
