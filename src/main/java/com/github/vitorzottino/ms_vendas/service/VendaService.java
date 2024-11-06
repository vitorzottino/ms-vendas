package com.github.vitorzottino.ms_vendas.service;

import com.github.vitorzottino.ms_vendas.dto.VendaDTO;
import com.github.vitorzottino.ms_vendas.enums.StatusVenda;
import com.github.vitorzottino.ms_vendas.exceptions.VendaDoesntExistException;
import com.github.vitorzottino.ms_vendas.exceptions.VendedorDoesntExistException;
import com.github.vitorzottino.ms_vendas.model.Venda;
import com.github.vitorzottino.ms_vendas.repository.VendaRepository;
import com.github.vitorzottino.ms_vendas.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendaService {

    private static final double VENDA_ALTA = 30000;
    private static final double VENDA_BAIXA = 15000;

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    VendedorRepository vendedorRepository;

    @Transactional(readOnly = true)
    public List<VendaDTO> findAll() {
        return vendaRepository.findAll().stream().map(VendaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public VendaDTO findById(Long id) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new VendaDoesntExistException(id));

        return new VendaDTO(venda);
    }

    @Transactional(readOnly = true)
    public VendaDTO insert(VendaDTO dto){
        calculateStatus(dto);
        Venda venda = new Venda(dto);
        if(venda.getVendedor() == null)
            throw new RuntimeException("vendedor null");
        if(vendedorRepository.getReferenceById(venda.getVendedor().getId()) == null){
            throw new VendedorDoesntExistException(venda.getVendedor().getId());
        }
        venda = vendaRepository.save(venda);
        return new VendaDTO(venda);

    }

    public void calculateStatus(VendaDTO dto){
        if(dto.getTotal() >= VENDA_ALTA){
            dto.setStatus(StatusVenda.ALTA);
        } else if (dto.getTotal() < VENDA_BAIXA ) {
            dto.setStatus(StatusVenda.BAIXA);
        }
        dto.setStatus(StatusVenda.MEDIA);
    }
}
