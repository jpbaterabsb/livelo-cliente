package com.livelo.client.backend.adapter.api;


import com.livelo.client.backend.adapter.mapper.ClienteDTO;
import com.livelo.client.backend.constants.Path;
import com.livelo.client.core.domain.Cliente;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(Path.CLIENTE)
public interface ClienteRest {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Cliente save(@Valid @RequestBody ClienteDTO clienteDTO);


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ClienteDTO> findAll();
}