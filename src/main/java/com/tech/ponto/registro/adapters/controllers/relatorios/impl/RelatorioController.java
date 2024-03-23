package com.tech.ponto.registro.adapters.controllers.relatorios.impl;

import com.tech.ponto.registro.adapters.controllers.relatorios.IRelatorioController;
import com.tech.ponto.registro.adapters.controllers.relatorios.dtos.RelatorioRegistroPontoResponseDTO;
import com.tech.ponto.registro.usecase.services.relatorios.impl.RelatorioPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController implements IRelatorioController {

  @Autowired
  private RelatorioPontoService service;

  @Override
  public ResponseEntity<RelatorioRegistroPontoResponseDTO> gerarRelatorioDePontoPorUsuario(UUID idUsuario) {
    return ResponseEntity.ok(service.gerarRelatorioDePontoPorUsuario(idUsuario));
  }
}
