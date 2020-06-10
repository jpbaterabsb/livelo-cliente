package com.livelo.application.client.mapper;

import com.livelo.application.client.domain.Cidade;
import org.mapstruct.Mapper;

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
