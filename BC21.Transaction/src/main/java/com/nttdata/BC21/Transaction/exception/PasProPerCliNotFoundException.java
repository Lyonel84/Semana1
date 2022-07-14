package com.nttdata.BC21.Transaction.exception;

public class PasProPerCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "PASIVE PRODUCT PERSON CLIEN NOT FOUND";

    public PasProPerCliNotFoundException(){
        super(MESSAGE);
    }
}
