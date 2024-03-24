package com.tech.ponto.registro.adapters.controllers.auth;

import com.tech.ponto.registro.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
  private String token;
  private String nome;
  private UserRole role;
  private String matricula;
}
