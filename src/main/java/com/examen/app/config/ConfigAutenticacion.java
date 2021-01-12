package com.examen.app.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("consulta-escribano.ws")
public class ConfigAutenticacion {
  private String url;
  private String subject;
  private String audience;
  private String issuer;
  private String sign;
  private String role;
}
