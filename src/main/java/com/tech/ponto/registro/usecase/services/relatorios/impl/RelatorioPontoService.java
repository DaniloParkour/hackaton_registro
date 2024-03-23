package com.tech.ponto.registro.usecase.services.relatorios.impl;

import com.tech.ponto.registro.adapters.controllers.relatorios.dtos.ItemListaRelatorioRegistroPontoResponseDTO;
import com.tech.ponto.registro.adapters.controllers.relatorios.dtos.RelatorioRegistroPontoResponseDTO;
import com.tech.ponto.registro.domain.model.RegistroPonto;
import com.tech.ponto.registro.domain.model.Usuario;
import com.tech.ponto.registro.usecase.repository.RegistroPontoRepository;
import com.tech.ponto.registro.usecase.repository.UsuarioRepository;
import com.tech.ponto.registro.usecase.services.relatorios.IRelatorioPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RelatorioPontoService implements IRelatorioPontoService {

  @Autowired
  private RegistroPontoRepository repositoryRegistro;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public RelatorioRegistroPontoResponseDTO gerarRelatorioDePontoPorUsuario(UUID idUsuario) {
    Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
    if(usuario.isPresent()) {
      var registros = repositoryRegistro.findByUsuarioIdOrderByDataHoraDesc(idUsuario);
      RelatorioRegistroPontoResponseDTO relatorio = new RelatorioRegistroPontoResponseDTO();
      relatorio.setNome(usuario.get().getNome());
      relatorio.setRole(usuario.get().getRole());
      relatorio.setMatricula(usuario.get().getMatricula());
      List<ItemListaRelatorioRegistroPontoResponseDTO> itemRegistroDTO = new ArrayList<ItemListaRelatorioRegistroPontoResponseDTO>();
      for(RegistroPonto item : registros) {
        ItemListaRelatorioRegistroPontoResponseDTO itemDTO = new ItemListaRelatorioRegistroPontoResponseDTO();
        itemDTO.setSituacao(item.getSituacao());
        itemDTO.setDataHora(item.getDataHora());
        itemDTO.setDataDeAtualizacao(item.getDataDeAtualizacao());
        itemRegistroDTO.add(itemDTO);
      }
      relatorio.setListaDeRegistroDePopntos(itemRegistroDTO);
      return relatorio;
    }
    return null;
  }

}
