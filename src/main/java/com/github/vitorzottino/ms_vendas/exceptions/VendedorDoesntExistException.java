package com.github.vitorzottino.ms_vendas.exceptions;

import lombok.Getter;

@Getter
public class VendedorDoesntExistException extends RuntimeException{

    private static final String  MESSAGE = "Vendedor doesnt exist with id %s";
    private final Long vendedorId;

    public VendedorDoesntExistException(Long vendedorId) {
        super(String.format(MESSAGE, vendedorId));
        this.vendedorId = vendedorId;
    }
}
