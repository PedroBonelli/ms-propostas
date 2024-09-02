package com.github.pedrobonelli.ms_proposta.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private BigDecimal renda;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Proposta> propostas;

}

//PEDRO BONELLI RM93369
//LUCAS GREGIO MESSIAS RM93878
