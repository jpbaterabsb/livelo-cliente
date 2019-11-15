package com.livelo.application.client.mapper;

import com.livelo.application.client.domain.Sexo;
import com.livelo.application.client.validator.ValueOfEnum;
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

    @NotNull
    private Integer cidadeId;
}
