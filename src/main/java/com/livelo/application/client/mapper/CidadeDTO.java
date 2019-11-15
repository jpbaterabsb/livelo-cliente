package com.livelo.application.client.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadeDTO {

    @NotNull
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String estado;
}
