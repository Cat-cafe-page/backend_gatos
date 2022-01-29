package com.catcafe.backend_gatos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice //controlador de sugerencias, genera la respuesta a un servicio web
@ResponseBody //Da la respuesta
public class GatoNotFoundAdvice {
    @ResponseBody //Genera la estructura de la respuesta
    @ExceptionHandler(GatoNotFoundException.class) //asocia el metodo
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(GatoNotFoundException ex){
        return ex.getMessage();
    }
}
