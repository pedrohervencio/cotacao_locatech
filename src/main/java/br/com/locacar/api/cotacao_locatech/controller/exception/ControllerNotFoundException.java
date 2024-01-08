package br.com.locacar.api.cotacao_locatech.controller.exception;

public class ControllerNotFoundException extends RuntimeException{
    public ControllerNotFoundException(String message) {
        super(message);
    }
}
