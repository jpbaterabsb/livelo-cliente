package com.livelo.application.client.service;

import com.livelo.application.client.domain.Cidade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CidadeService extends AbstractService<Cidade,Integer> {
}
