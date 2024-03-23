package com.tech.ponto.registro.adapters.controllers.dtos;

import com.tech.ponto.registro.domain.enums.Situacao;
import com.tech.ponto.registro.domain.model.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class RegistroPontoAtualizarRequestDTO {
  private UUID id;
  private Situacao situacao;
  private OffsetDateTime dataHora;
}
