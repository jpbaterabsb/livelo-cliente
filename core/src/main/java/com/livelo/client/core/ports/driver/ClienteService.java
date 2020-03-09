package com.livelo.client.core.ports.driver;

import com.livelo.client.core.domain.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente salvar(Cliente cliente);

    List<Cliente> buscarTodos();
}
