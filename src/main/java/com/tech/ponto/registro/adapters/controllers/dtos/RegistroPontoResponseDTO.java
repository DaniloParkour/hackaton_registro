package com.tech.ponto.registro.adapters.controllers.dtos;

import com.tech.ponto.registro.domain.enums.Situacao;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class RegistroPontoResponseDTO {
  private UUID id;
  private Situacao situacao;
  private OffsetDateTime dataHora;
  private OffsetDateTime dataDeAtualizacao;
}
