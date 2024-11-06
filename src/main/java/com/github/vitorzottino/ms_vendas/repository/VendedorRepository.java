package com.github.vitorzottino.ms_vendas.repository;

import com.github.vitorzottino.ms_vendas.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
