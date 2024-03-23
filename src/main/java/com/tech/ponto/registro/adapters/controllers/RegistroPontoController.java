package com.tech.ponto.registro.adapters.controllers;

import com.tech.ponto.registro.adapters.controllers.dtos.RegistroPontoAtualizarRequestDTO;
import com.tech.ponto.registro.adapters.controllers.dtos.RegistroPontoRequestDTO;
import com.tech.ponto.registro.adapters.controllers.dtos.RegistroPontoResponseDTO;
import com.tech.ponto.registro.domain.model.RegistroPonto;
import com.tech.ponto.registro.infra.mapper.IGenericMapper;
import com.tech.ponto.registro.usecase.services.IRegistroPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/registrar-ponto")
public class RegistroPontoController implements IRegistroPontoController {

  @Autowired
  private IRegistroPontoService service;

  @Autowired
  private IGenericMapper mapper;

  @Override
  public ResponseEntity<RegistroPontoResponseDTO> criarRegistroDePonto(RegistroPontoRequestDTO request) {
    RegistroPonto novoRegistro = service.criarRegistroDePonto(request.getUsuarioID());
    var response = mapper.toObject(novoRegistro, RegistroPontoResponseDTO.class);
    return ResponseEntity.ok(response);
  }

  @Override
  public ResponseEntity<RegistroPontoResponseDTO> atualizarRegistroDePonto(RegistroPontoAtualizarRequestDTO request) {
    RegistroPonto registroPontoAtualizado = service.atualizarRegistroDePonto(mapper.toObject(request, RegistroPonto.class));
    return ResponseEntity.ok(mapper.toObject(registroPontoAtualizado, RegistroPontoResponseDTO.class));
  }

  @Override
  public ResponseEntity<List<RegistroPontoResponseDTO>> listarRegistroDePontoPorUsuario(UUID idUsuario) {
    List<RegistroPonto> registroPontoList = service.listarRegistroDePontoPorUsuario(idUsuario);
    return ResponseEntity.ok(mapper.toList(registroPontoList, RegistroPontoResponseDTO.class));
  }
}
