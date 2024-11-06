package com.github.vitorzottino.ms_vendas.exceptions;

import lombok.Getter;

@Getter
public class VendaDoesntExistException extends RuntimeException{

    private static final String  MESSAGE = "Venda doesnt exist with id %s";
    private final Long vendaId;

    public VendaDoesntExistException(Long vendaId) {
        super(String.format(MESSAGE, vendaId));
        this.vendaId = vendaId;
    }
}
