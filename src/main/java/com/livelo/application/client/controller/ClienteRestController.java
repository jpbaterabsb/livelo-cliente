package com.livelo.application.client.controller;

import com.livelo.application.client.constants.Path;
import com.livelo.application.client.domain.Cliente;
import com.livelo.application.client.mapper.ClienteDTO;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping(Path.CLIENTE)
@RequestScope
public class ClienteRestController extends AbstractRestController<Cliente,Integer, ClienteDTO> {

}
