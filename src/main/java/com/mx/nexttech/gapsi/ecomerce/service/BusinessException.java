/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nexttech.gapsi.ecomerce.service;

import org.springframework.http.HttpStatus;

/**
 *
 * @author ArminJesusLunaMorale
 */
public class BusinessException extends Exception {

    private HttpStatus httpStatus;
    private String mensaje;

    public BusinessException(HttpStatus httpStatus, String mensaje) {
        this.httpStatus = httpStatus;
        this.mensaje = mensaje;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
