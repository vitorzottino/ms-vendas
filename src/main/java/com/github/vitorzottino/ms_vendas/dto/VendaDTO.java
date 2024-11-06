package com.github.vitorzottino.ms_vendas.dto;

import com.github.vitorzottino.ms_vendas.enums.StatusVenda;
import com.github.vitorzottino.ms_vendas.model.Venda;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendaDTO {

    private Long id;

    @NotNull(message = "Mandatory field")
    @Positive(message = "Positive value only")
    private Double total;

    @FutureOrPresent
    private LocalDate data;

    private Double comissao;

    private StatusVenda status;

    private VendedorDTO vendedor;

    public VendaDTO(Venda venda){
        id = venda.getId();
        total = venda.getTotal();
        data = venda.getData();
        comissao = venda.getTotal() * 0.10;
        status = venda.getStatus();
        vendedor = new VendedorDTO(venda.getVendedor());

    }
}
