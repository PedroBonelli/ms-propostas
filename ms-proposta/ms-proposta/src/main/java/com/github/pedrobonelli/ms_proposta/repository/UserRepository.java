package com.github.pedrobonelli.ms_proposta.repository;

import com.github.pedrobonelli.ms_proposta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
