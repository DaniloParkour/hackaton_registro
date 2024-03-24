package com.tech.ponto.registro.usecase.repository;


import com.tech.ponto.registro.domain.model.RegistroPonto;
import com.tech.ponto.registro.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
  UserDetails findByMatricula(String login);
}
