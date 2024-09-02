package com.github.pedrobonelli.ms_proposta.dto;

import com.github.pedrobonelli.ms_proposta.model.Proposta;
import com.github.pedrobonelli.ms_proposta.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropostaDTO {

    private Long id;

    @NotNull(message = "O valor da proposta é obrigatório")
    private BigDecimal valorSolicitado;

    @NotNull(message = "O prazo para pagamento é obrigatório")
    private Integer prazoParaPagamento;

    private Boolean aprovado;

    @NotNull
    private Long userId;

    public PropostaDTO(Proposta entity){
        this.id = entity.getId();
        this.valorSolicitado = entity.getValorSolicitado();
        this.prazoParaPagamento = entity.getPrazoParaPagamento();
        this.aprovado = entity.getAprovado();

        this.userId = entity.getUsuario().getId();
    }

    public PropostaDTO(FormPropostaDTO formDTO){
        this.valorSolicitado = formDTO.getValorSolicitado();
        this.prazoParaPagamento = formDTO.getPrazoEmMeses();
        this.aprovado = false;
    }

}

//PEDRO BONELLI RM93369
//LUCAS GREGIO MESSIAS RM93878
