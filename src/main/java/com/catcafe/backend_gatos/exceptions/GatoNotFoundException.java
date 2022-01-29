package com.catcafe.backend_gatos.exceptions;

public class GatoNotFoundException extends RuntimeException{
    public GatoNotFoundException(String message){
        super(message);
    }
}
