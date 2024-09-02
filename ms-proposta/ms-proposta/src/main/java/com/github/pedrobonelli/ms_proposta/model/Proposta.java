package com.github.pedrobonelli.ms_proposta.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Propostas")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorSolicitado;
    private Integer prazoParaPagamento;
    private Boolean aprovado = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario", nullable = false)
    private User usuario;

}

//PEDRO BONELLI RM93369
//LUCAS GREGIO MESSIAS RM93878
