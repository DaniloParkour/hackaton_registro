package com.tech.ponto.registro.usecase.services.relatorios;

import com.tech.ponto.registro.adapters.controllers.relatorios.dtos.RelatorioRegistroPontoResponseDTO;

import java.util.UUID;

public interface IRelatorioPontoService {
  public RelatorioRegistroPontoResponseDTO gerarRelatorioDePontoPorUsuario(UUID idUsuario);
}
