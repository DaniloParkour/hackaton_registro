package com.tech.ponto.registro.adapters.controllers.auth;

import com.tech.ponto.registro.domain.model.Usuario;
import com.tech.ponto.registro.infra.config.security.TokenService;
import com.tech.ponto.registro.infra.mapper.IGenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private IGenericMapper mapper;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDTO> auth(@RequestBody AuthDTO request) {
    UsernamePasswordAuthenticationToken usuarioSenha = new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getSenha());
    Authentication auth = this.authenticationManager.authenticate(usuarioSenha);

    Usuario usuario = (Usuario) auth.getPrincipal();

    var token = tokenService.gerarToken(usuario);

    return ResponseEntity.ok(new LoginResponseDTO(usuario.getId(), token, usuario.getNome(), usuario.getRole(), usuario.getMatricula()));
  }

}
