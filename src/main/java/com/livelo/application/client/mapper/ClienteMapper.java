package com.livelo.application.client.mapper;

import com.livelo.application.client.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends IMapper<Cliente,ClienteDTO> {
    @Override
    @Mapping(source = "cidade.id", target = "cidadeId")
    ClienteDTO toDTO(Cliente cliente);

    @Override
    @Mapping(target = "cidade.id", source = "cidadeId")
    Cliente fromDTO(ClienteDTO clienteDTO);

    @Override
    List<ClienteDTO> toDTO(List<Cliente> t);

    @Override
    List<Cliente> fromDTO(List<ClienteDTO> dto);
}
