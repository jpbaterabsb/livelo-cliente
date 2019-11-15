package com.livelo.application.client.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface IRestController<T, ID, DTO> {

    public DTO findById(ID id);

    public List<DTO> find(Map<String,Object> params);


    public void deleteById(ID id);

    public DTO save(DTO dto);

    public DTO update(DTO dto, ID id);

    DTO updatePartial(Map<String,Object> params, ID id);
}