package com.tech.ponto.registro.usecase.services.impl;

import com.tech.ponto.registro.domain.enums.Situacao;
import com.tech.ponto.registro.domain.model.RegistroPonto;
import com.tech.ponto.registro.domain.model.Usuario;
import com.tech.ponto.registro.usecase.repository.RegistroPontoRepository;
import com.tech.ponto.registro.usecase.repository.UsuarioRepository;
import com.tech.ponto.registro.usecase.services.IRegistroPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
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

      registroPonto.setSituacao(Situacao.ENTRADA);

      Optional<RegistroPonto> ultimoRegistro = repositoryRegistro.findTopByUsuarioIdOrderByDataHoraDesc(idUsuario);

      if(ultimoRegistro.isPresent()) {
        long diferencaEmHoras = ChronoUnit.HOURS.between(ultimoRegistro.get().getDataHora(), OffsetDateTime.now());
        if(diferencaEmHoras <= 12 && ultimoRegistro.get().getSituacao().equals(Situacao.ENTRADA)) {
          registroPonto.setSituacao(Situacao.SAIDA);
        }
        System.out.println("Ultimo ponto marcado há " + diferencaEmHoras + " horas.");
      }

      return repositoryRegistro.save(registroPonto);
    }
    return null;
  }

  @Override
  public RegistroPonto atualizarRegistroDePonto(RegistroPonto registroDePonto) {
    Optional<RegistroPonto> registroPontoEncontrado = repositoryRegistro.findById(registroDePonto.getId());
    if(registroPontoEncontrado.isPresent()) {
      Optional<Usuario> usuario = repositoryUsuario.findById(registroPontoEncontrado.get().getUsuario().getId());
      if(usuario.isPresent()) {
        RegistroPonto registroAtualizado = registroPontoEncontrado.get();
        registroAtualizado.setSituacao(registroDePonto.getSituacao());
        registroAtualizado.setDataHora(registroDePonto.getDataHora());
        registroAtualizado.setDataDeAtualizacao(OffsetDateTime.now());
        return repositoryRegistro.save(registroAtualizado);
      }
    }
    return null;
  }

  @Override
  public List<RegistroPonto> listarRegistroDePontoPorUsuario(UUID idUsuario) throws Exception {

    Optional<Usuario> user = repositoryUsuario.findById(idUsuario);

    if(user.isEmpty() || !SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals(user.get().getMatricula())) {
      throw new Error("Usuário inisistente ou não permitido");
    }

    return repositoryRegistro.findByUsuarioId(idUsuario);
  }

}
