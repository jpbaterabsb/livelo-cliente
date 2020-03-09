package com.livelo.client.core.service;

import com.livelo.client.core.domain.Cliente;
import com.livelo.client.core.ports.driven.ClienteRepository;
import com.livelo.client.core.ports.driver.ClienteService;
import com.livelo.client.core.validation.Assert;
import com.livelo.client.core.validation.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) {
        Assert.isNotNull(cliente.getNomeCompleto(), Message.ERRO_NOME_NULO);
        Assert.isTrue(cliente.getIdade() >= 18, Message.ERRO_CLIENTE_MENOR_IDADE);
        return clienteRepository.salvar(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.buscarTodos();
    }
}
