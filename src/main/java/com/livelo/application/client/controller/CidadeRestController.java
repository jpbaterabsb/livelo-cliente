package com.livelo.application.client.controller;


import com.livelo.application.client.constants.Path;
import com.livelo.application.client.domain.Cidade;
import com.livelo.application.client.mapper.CidadeDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping(Path.CIDADE)
@RequestScope
public class CidadeRestController extends AbstractRestController<Cidade, Integer, CidadeDTO>{
}
