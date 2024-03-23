package com.tech.ponto.registro.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthcheckController {
  @GetMapping
  public ResponseEntity<String> healthCheck() {
    return ResponseEntity.ok("OK");
  }
}
