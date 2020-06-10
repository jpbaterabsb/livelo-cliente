package com.livelo.application.client.controller;

import com.livelo.application.client.constants.Path;
import com.livelo.application.client.controller.controller.CrudRestTest;
import com.livelo.application.client.domain.Cidade;
import com.livelo.application.client.domain.Estado;
import com.livelo.application.client.domain.Sexo;
import com.livelo.application.client.mapper.ClienteDTO;
import com.livelo.application.client.repository.CidadeRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteRestControllerTest extends CrudRestTest<ClienteDTO,Integer> {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Before
    public void createCidade(){
        cidadeRepository.save(Cidade.builder()
                .estado("MG")
                .nome("Sobradinho")
                .build());
        super.setUp();
    }

    @Override
    protected ClienteDTO createObject() {
        return ClienteDTO.builder()
                .cidadeId(1)
                .dataNascimento(LocalDate.of(2000,11,1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .idade(23)
                .nomeCompleto("Joao Paulo Oliveira Santos")
                .sexo(Sexo.MASCULINO.name())
                .id(1)
                .build();
    }

    @Override
    protected ClienteDTO setObject(ClienteDTO clienteDTO) {
        clienteDTO.setNomeCompleto("Marcelo Moura");
        clienteDTO.setIdade(23);
        return clienteDTO;
    }

    @Override
    protected String getPath() {
        return Path.CLIENTE;
    }

    @Override
    protected UriComponentsBuilder getUriWithRequestParams() {
        return uriComponentsBuilder.queryParam("nome","Joao Paulo Oliveira Santos");
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
