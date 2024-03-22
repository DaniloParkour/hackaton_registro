package com.tech.ponto.registro.usecase.repository;


import com.tech.ponto.registro.domain.model.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, UUID> {
  public List<RegistroPonto> findByUsuarioId(UUID usuarioId);
}
