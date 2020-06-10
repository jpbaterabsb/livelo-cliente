package com.livelo.application.client.controller;

import java.util.List;
import java.util.Map;

public interface IRestController<T, ID, DTO> {

    DTO findById(ID id);

    List<DTO> find(Map<String, Object> params);


    void deleteById(ID id);

    DTO save(DTO dto);

    DTO update(DTO dto, ID id);

    DTO updatePartial(Map<String, Object> params, ID id);
}