package com.tech.ponto.registro.adapters.controllers.relatorios.dtos;

import com.tech.ponto.registro.domain.enums.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class RelatorioRegistroPontoResponseDTO {
  private String nome;
  private Long matricula;
  private UserRole role;
  private List<ItemListaRelatorioRegistroPontoResponseDTO> listaDeRegistroDePopntos;
}
