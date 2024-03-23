package com.tech.ponto.registro.adapters.controllers.relatorios;

import com.tech.ponto.registro.adapters.controllers.relatorios.dtos.RelatorioRegistroPontoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface IRelatorioController {
  @GetMapping("/{idUsuario}")
  public ResponseEntity<RelatorioRegistroPontoResponseDTO> gerarRelatorioDePontoPorUsuario(@PathVariable UUID idUsuario);
}
