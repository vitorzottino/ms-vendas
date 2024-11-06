package com.github.vitorzottino.ms_vendas.repository;

import com.github.vitorzottino.ms_vendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
