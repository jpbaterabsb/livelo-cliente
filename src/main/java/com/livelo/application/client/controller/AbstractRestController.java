package com.livelo.application.client.controller;

import java.util.List;
import java.util.Map;

import com.livelo.application.client.mapper.IMapper;
import com.livelo.application.client.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


public abstract class AbstractRestController<T, ID, DTO> implements IRestController<T, ID, DTO> {

    @Autowired
    private IService<T, ID> service;

    @Autowired
    private IMapper<T,DTO> mapper;

    @GetMapping
    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<DTO> find(@RequestParam Map<String, Object> params) {
        if (params.isEmpty()){
            return mapper.toDTO(this.service.findAll());
        }
        return mapper.toDTO(this.service.findByObject(params));
    }


    @GetMapping("/{id}")
    @CrossOrigin
    @Override
    @ResponseStatus(HttpStatus.OK)
    public DTO findById(@PathVariable ID id) {
        return mapper.toDTO(this.service.findById(id));
    }


    @Override
    @CrossOrigin
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable ID id) {
        this.service.deleteById(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DTO save(@Valid @RequestBody DTO dto) {
        T obj = this.service.save(mapper.fromDTO(dto));
        return mapper.toDTO(obj);
    }

    @Override
    @CrossOrigin
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DTO update(@Valid @RequestBody DTO dto, @PathVariable ID id) {
        T obj = this.service.update(mapper.fromDTO(dto),id);
        return mapper.toDTO(obj);
    }

}
