package com.github.vitorzottino.ms_vendas.model;


import com.github.vitorzottino.ms_vendas.dto.VendaDTO;
import com.github.vitorzottino.ms_vendas.enums.StatusVenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;
    private LocalDate data;
    private Double comissao;
    private StatusVenda status;

    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;

    public Venda(VendaDTO dto){
        this.id = dto.getId();
        this.total = dto.getTotal();
        this.data = dto.getData();
        this.comissao = dto.getTotal() * 0.10;
        this.status = dto.getStatus();
        this.vendedor = new Vendedor(dto.getVendedor());
    }
}
