package com.nttdata.BC210.ManagementClientProduct.exception;

public class ClientNotFoundException extends RuntimeException{
    private static final String MESSAGE = "CLIENT NOT FOUND";

    public ClientNotFoundException(){
        super(MESSAGE);
    }
}
