package com.catcafe.backend_gatos.exceptions;

public class GatoAlreadyExistsException extends RuntimeException{
    public GatoAlreadyExistsException(String message){
        super(message);
    }
}
