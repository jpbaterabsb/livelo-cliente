package com.livelo.client.backend.adapter.mapper;

import com.livelo.client.core.domain.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDTO toDTO(Cliente cliente);

    Cliente fromDTO(ClienteDTO clienteDTO);

    List<ClienteDTO> toDTO(List<Cliente> t);

    List<Cliente> fromDTO(List<ClienteDTO> dto);
}
