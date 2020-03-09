package com.livelo.client.backend.adapter.jpa.repository;

import com.livelo.client.core.domain.Cliente;
import com.livelo.client.core.ports.driven.ClienteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente,Integer>, ClienteRepository {

    @Override
    default Cliente salvar(Cliente cliente) {
        return save(cliente);
    }


    @Override
    default List<Cliente> buscarTodos() {
        return findAll();
    }
}
