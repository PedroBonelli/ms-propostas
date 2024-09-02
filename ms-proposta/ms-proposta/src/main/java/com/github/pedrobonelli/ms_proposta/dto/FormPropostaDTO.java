package com.github.pedrobonelli.ms_proposta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormPropostaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String telefone;

    @NotNull
    private BigDecimal renda;

    @NotNull
    private BigDecimal valorSolicitado;

    @NotNull
    private Integer prazoEmMeses;

}

//PEDRO BONELLI RM93369
//LUCAS GREGIO MESSIAS RM93878
