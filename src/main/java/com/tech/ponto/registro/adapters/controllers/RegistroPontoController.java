package com.tech.ponto.registro.adapters.controllers;

import com.tech.ponto.registro.adapters.controllers.dtos.RegistroPontoRequestDTO;
import com.tech.ponto.registro.adapters.controllers.dtos.RegistroPontoResponseDTO;
import com.tech.ponto.registro.domain.model.RegistroPonto;
import com.tech.ponto.registro.infra.mapper.IGenericMapper;
import com.tech.ponto.registro.usecase.services.IRegistroPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/registrar-ponto")
public class RegistroPontoController {

  @Autowired
  private IRegistroPontoService service;

  @Autowired
  private IGenericMapper mapper;

  @PostMapping
  public RegistroPontoResponseDTO save(@RequestBody RegistroPontoRequestDTO request) {
    RegistroPonto novoRegistro = service.criarRegistroDePonto(request.getUsuarioID());
    var response = mapper.toObject(novoRegistro, RegistroPontoResponseDTO.class);
    return response;
  }
}
