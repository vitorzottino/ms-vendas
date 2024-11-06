package com.github.vitorzottino.ms_vendas.controller;

import com.github.vitorzottino.ms_vendas.dto.VendaDTO;
import com.github.vitorzottino.ms_vendas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping()
    public ResponseEntity<VendaDTO> insert(@RequestBody VendaDTO dto) {
        dto = vendaService.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
