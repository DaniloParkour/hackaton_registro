package com.tech.ponto.registro.adapters.controllers;

import com.tech.ponto.registro.adapters.controllers.dtos.RegistroPontoAtualizarRequestDTO;
import com.tech.ponto.registro.adapters.controllers.dtos.RegistroPontoRequestDTO;
import com.tech.ponto.registro.adapters.controllers.dtos.RegistroPontoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface IRegistroPontoController {
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<RegistroPontoResponseDTO> criarRegistroDePonto(@RequestBody RegistroPontoRequestDTO request);
  @PutMapping
  public ResponseEntity<RegistroPontoResponseDTO> atualizarRegistroDePonto(@RequestBody RegistroPontoAtualizarRequestDTO request);
  @GetMapping("/{idUsuario}")
  public ResponseEntity<List<RegistroPontoResponseDTO>> listarRegistroDePontoPorUsuario(@PathVariable UUID idUsuario);
}
