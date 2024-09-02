package com.github.pedrobonelli.ms_proposta.repository;

import com.github.pedrobonelli.ms_proposta.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
}
