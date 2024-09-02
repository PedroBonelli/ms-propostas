package com.github.pedrobonelli.ms_proposta.dto;

import com.github.pedrobonelli.ms_proposta.model.Proposta;

import com.github.pedrobonelli.ms_proposta.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {


    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotNull(message = "Renda é obrigatório")
    private BigDecimal renda;

//    private List<PropostaDTO> propostasDTO = new ArrayList<>();

    public UserDTO(User entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.cpf = entity.getCpf();
        this.telefone = entity.getTelefone();
        this.renda = entity.getRenda();

//        List<PropostaDTO> dtos = new ArrayList<>();
//        for(Proposta proposta : entity.getPropostas()){
//            this.propostasDTO.add(new PropostaDTO(proposta));
//        }

    }

    public UserDTO(FormPropostaDTO formDTO){
        this.nome = formDTO.getNome();
        this.sobrenome = formDTO.getSobrenome();
        this.cpf = formDTO.getCpf();
        this.telefone = formDTO.getTelefone();
        this.renda = formDTO.getRenda();
    }

}

//PEDRO BONELLI RM93369
//LUCAS GREGIO MESSIAS RM93878
