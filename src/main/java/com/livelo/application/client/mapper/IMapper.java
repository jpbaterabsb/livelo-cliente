package com.livelo.application.client.mapper;

import java.util.List;

public interface IMapper<T,DTO> {
   DTO toDTO(T t);
   T fromDTO(DTO dto);
   List<DTO> toDTO(List<T> t);
   List<T> fromDTO(List<DTO> dto);
}
