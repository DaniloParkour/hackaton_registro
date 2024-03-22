package com.tech.ponto.registro.domain.model;

import com.tech.ponto.registro.domain.enums.Situacao;
import com.tech.ponto.registro.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Generated
@Data
public class RegistroPonto {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private UUID id;
  @Enumerated(EnumType.STRING)
  private Situacao situacao;
  private OffsetDateTime dataHora;
  private OffsetDateTime dataDeAtualizacao;

  @ManyToOne
  @JoinColumn(name = "usuarioID")
  private Usuario usuario;
}
