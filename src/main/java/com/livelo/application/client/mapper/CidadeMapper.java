package com.livelo.application.client.mapper;

import com.livelo.application.client.domain.Cidade;
import com.livelo.application.client.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CidadeMapper extends IMapper<Cidade,CidadeDTO> {

    @Override
    CidadeDTO toDTO(Cidade cidade);


    @Override
    Cidade fromDTO(CidadeDTO cidadeDTO);

    @Override
    List<CidadeDTO> toDTO(List<Cidade> t);

    @Override
    List<Cidade> fromDTO(List<CidadeDTO> dto);
}
