package com.tech.ponto.registro.usecase.services;

import com.tech.ponto.registro.domain.model.RegistroPonto;

import java.util.List;
import java.util.UUID;

public interface IRegistroPontoService {
  public RegistroPonto criarRegistroDePonto(UUID idUsuario);
  public RegistroPonto atualizarRegistroDePonto(RegistroPonto registroDePonto);
  public List<RegistroPonto> listarRegistroDePontoPorUsuario(UUID idUsuario) throws Exception;
}
