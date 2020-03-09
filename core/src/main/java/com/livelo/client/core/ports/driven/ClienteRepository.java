package com.livelo.client.core.ports.driven;

import com.livelo.client.core.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente salvar(Cliente cliente);
    List<Cliente> buscarTodos();
}
