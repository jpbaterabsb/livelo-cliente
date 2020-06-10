package com.livelo.application.client.mapper;

import com.livelo.application.client.domain.Estado;
import com.livelo.application.client.validator.AlphaSpace;
import com.livelo.application.client.validator.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadeDTO {

    private Integer id;

    @NotBlank
    @AlphaSpace(message = "name must not contain special characters or numbers")
    private String nome;

    @NotBlank
    @ValueOfEnum(enumClass = Estado.class, message = "State value does not exist")
    private String estado;
}
