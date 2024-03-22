package com.tech.ponto.registro.adapters.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tech.ponto.registro.domain.enums.Situacao;
import com.tech.ponto.registro.domain.model.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class RegistroPontoResponseDTO {
  private Situacao situacao;
  private OffsetDateTime dataHora;
}
