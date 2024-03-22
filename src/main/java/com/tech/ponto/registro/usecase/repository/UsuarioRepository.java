package com.tech.ponto.registro.usecase.repository;


import com.tech.ponto.registro.domain.model.RegistroPonto;
import com.tech.ponto.registro.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
