package com.tech.ponto.registro.adapters.controllers.relatorios.dtos;

import com.tech.ponto.registro.domain.enums.Situacao;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ItemListaRelatorioRegistroPontoResponseDTO {
  private OffsetDateTime dataHora;
  private OffsetDateTime dataDeAtualizacao;
  private Situacao situacao;
}
