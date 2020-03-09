package com.livelo.client.core.validation;

import lombok.RequiredArgsConstructor;


public enum Message implements MessageCode {
    ERRO_NOME_NULO, ERRO_CLIENTE_MENOR_IDADE;




    @Override
    public String code() {
        return this.name();
    }
}
