package com.tech.ponto.registro.domain.model;

import com.tech.ponto.registro.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;
import java.util.UUID;

@Entity
@Generated
@Data
public class Usuario {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private UUID id;
  private String nome;
  private Long matricula;
  private String senha;
  @Enumerated(EnumType.STRING)
  private UserRole role;
}
