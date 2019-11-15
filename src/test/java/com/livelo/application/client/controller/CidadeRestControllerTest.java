package com.livelo.application.client.controller;

import com.livelo.application.client.constants.Path;
import com.livelo.application.client.controller.controller.CrudRestTest;
import com.livelo.application.client.mapper.CidadeDTO;
import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

public class CidadeRestControllerTest extends CrudRestTest<CidadeDTO,Integer> {

    @Override
    protected CidadeDTO createObject() {
        return CidadeDTO.builder()
                .nome("Sobradinho")
                .estado("DF")
                .id(1)
                .build();
    }

    @Override
    protected CidadeDTO setObject(CidadeDTO cidadeDTO) {
        cidadeDTO.setNome("Alphaville");
        cidadeDTO.setEstado("SP");
        return cidadeDTO;
    }

    @Override
    protected String getPath() {
        return Path.CIDADE;
    }

    @Override
    protected UriComponentsBuilder getUriWithRequestParams() {
        return uriComponentsBuilder
                .queryParam("estado","DF")
                .queryParam("cidade","Sobradinho");
    }


    @Test
    public void create() throws Exception {
        super.create();
    }

    @Test
    public void update() throws Exception {
        super.update();
    }

    @Test
    public void delete() throws Exception {
        super.delete();
    }

    @Test
    public void read() throws Exception {
        super.read();
    }

    @Test
    public void findById() throws Exception {
        super.findById();
    }

    @Test
    public void findByRequestParam() throws Exception {
        super.findByRequestParam();
    }
}
