package com.nttdata.BC21.Transaction.exception;

public class ActProCrePerCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "ACTIVE PRODUCT CREDIT PERSON CLIEN NOT FOUND";

    public ActProCrePerCliNotFoundException(){
        super(MESSAGE);
    }
}
