package com.livelo.client.backend.adapter.mapper;

import com.livelo.client.backend.validator.ValueOfEnum;
import com.livelo.client.core.domain.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    @NotNull
    private Integer id;

    @NotBlank
    private String nomeCompleto;

    @ValueOfEnum(enumClass = Sexo.class, message = "Enum value not exist")
    private String sexo;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private Integer idade;
}
