package com.github.vitorzottino.ms_vendas.model;

import com.github.vitorzottino.ms_vendas.dto.VendedorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "vendedor")
    private List<Venda> vendas = new ArrayList<>();

    public Vendedor(VendedorDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.email = dto.getEmail();
    }
}
