package com.github.vitorzottino.ms_vendas.dto;

import com.github.vitorzottino.ms_vendas.model.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VendedorDTO {

    public Long id;
    public String nome;
    public String email;

    public VendedorDTO(Vendedor vendedor){
        id = vendedor.getId();
        nome = vendedor.getNome();
        email = vendedor.getEmail();
    }
}
