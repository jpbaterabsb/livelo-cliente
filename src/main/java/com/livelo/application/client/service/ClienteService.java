package com.livelo.application.client.service;

import com.livelo.application.client.domain.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteService extends AbstractService<Cliente,Integer> {
}
