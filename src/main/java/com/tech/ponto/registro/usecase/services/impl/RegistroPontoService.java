package com.tech.ponto.registro.usecase.services.impl;

import com.tech.ponto.registro.domain.enums.Situacao;
import com.tech.ponto.registro.domain.model.RegistroPonto;
import com.tech.ponto.registro.domain.model.Usuario;
import com.tech.ponto.registro.usecase.repository.RegistroPontoRepository;
import com.tech.ponto.registro.usecase.repository.UsuarioRepository;
import com.tech.ponto.registro.usecase.services.IRegistroPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistroPontoService implements IRegistroPontoService {

  @Autowired
  private RegistroPontoRepository repositoryRegistro;

  @Autowired
  private UsuarioRepository repositoryUsuario;

  @Override
  public RegistroPonto criarRegistroDePonto(UUID idUsuario) {
    Optional<Usuario> usuario = repositoryUsuario.findById(idUsuario);
    if(usuario.isPresent()) {
      RegistroPonto registroPonto = new RegistroPonto();
      registroPonto.setUsuario(usuario.get());
      registroPonto.setDataHora(OffsetDateTime.now());

      //Lógica para verificar se é ENTRADA ou SAIDA
      registroPonto.setSituacao(Situacao.ENTRADA);

      return repositoryRegistro.save(registroPonto);
    }
    return null;
  }

  @Override
  public RegistroPonto atualizarRegistroDePonto(RegistroPonto registroDePonto, UUID idUsuario) {
    Optional<Usuario> usuario = repositoryUsuario.findById(idUsuario);
    if(usuario.isPresent()) {
      Optional<RegistroPonto> registroPonto = repositoryRegistro.findById(registroDePonto.getId());
      if(registroPonto.isPresent()) {
        return repositoryRegistro.save(registroDePonto);
      }
    }
    return null;
  }

  @Override
  public List<RegistroPonto> listarRegistroDePontoPorUsuario(UUID idUsuario) {

    return null;
  }

}
