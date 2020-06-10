package com.livelo.application.client.controller;

import com.livelo.application.client.mapper.IMapper;
import com.livelo.application.client.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


public abstract class AbstractRestController<T, ID, DTO> implements IRestController<T, ID, DTO> {

    @Autowired
    private IService<T, ID> service;

    @Autowired
    private IMapper<T,DTO> mapper;

    @GetMapping
    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<DTO> find(@RequestParam(required = false) final Map<String, Object> params) {
        if (params.isEmpty()){
            return mapper.toDTO(this.service.findAll());
        }
        return mapper.toDTO(this.service.findByObject(params));
    }


    @GetMapping("/{id}")
    @CrossOrigin
    @Override
    @ResponseStatus(HttpStatus.OK)
    public DTO findById(@PathVariable final ID id) {
        return mapper.toDTO(this.service.findById(id));
    }


    @Override
    @CrossOrigin
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable final ID id) {
        this.service.deleteById(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DTO save(@Valid @RequestBody final DTO dto) {
        final T obj = this.service.save(mapper.fromDTO(dto));
        return mapper.toDTO(obj);
    }

    @Override
    @CrossOrigin
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DTO update(@Valid @RequestBody final DTO dto, @PathVariable final ID id) {
        final T obj = this.service.update(mapper.fromDTO(dto),id);
        return mapper.toDTO(obj);
    }

    @Override
    @CrossOrigin
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DTO updatePartial(@Valid @RequestBody final Map<String, Object> map, @PathVariable final ID id) {
        final T obj = this.service.updatePartial(map,id);
        return mapper.toDTO(obj);
    }

}
