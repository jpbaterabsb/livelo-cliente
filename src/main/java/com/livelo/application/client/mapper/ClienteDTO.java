package com.livelo.application.client.mapper;

import com.livelo.application.client.domain.Cidade;
import com.livelo.application.client.domain.Sexo;
import com.livelo.application.client.validator.AlphaSpace;
import com.livelo.application.client.validator.ForeignExists;
import com.livelo.application.client.validator.ValidDate;
import com.livelo.application.client.validator.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    private Integer id;

    @NotBlank
    @AlphaSpace(message = "name must not contain special characters or numbers")
    private String nomeCompleto;

    @ValueOfEnum(enumClass = Sexo.class, message = "Enum value not exist")
    private String sexo;

    @NotNull
    @ValidDate(format = "yyyy-MM-dd", message = "Invalid format date, expect: yyyy-MM-dd")
    private String dataNascimento;

    @NotNull
    @Max(150)
    @Min(18)
    private Integer idade;

    @NotNull
    @ForeignExists(entity = Cidade.class, message = "Cidade does not exists")
    private Integer cidadeId;
}
