package com.livelo.application.client.domain;

import com.livelo.application.client.validator.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeCompleto;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private Integer idade;

    @ManyToOne
    private Cidade cidade;


}
