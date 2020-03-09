package com.livelo.client.backend.adapter.rest.controller;

import com.livelo.client.backend.adapter.api.ClienteRest;
import com.livelo.client.backend.adapter.mapper.ClienteDTO;
import com.livelo.client.backend.adapter.mapper.ClienteMapper;
import com.livelo.client.core.domain.Cliente;
import com.livelo.client.core.ports.driver.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestScope
@RequiredArgsConstructor
public class ClienteRestController implements ClienteRest {

    private final ClienteMapper clienteMapper;
    private final ClienteService clienteService;

    @Override
    public Cliente save(@Valid ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.fromDTO(clienteDTO);
        return clienteService.salvar(cliente);
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteMapper.toDTO(clienteService.buscarTodos());
    }

}
