package com.examen.app.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtConfig {

  @Autowired
  private ConfigAutenticacion config;

  public String getToken() {
    Claims claims = Jwts.claims();
    claims.put("role", config.getRole());
    String token = Jwts.builder().setClaims(claims).setSubject(config.getSubject()).setAudience(config.getAudience())
        .setIssuer(config.getIssuer()).signWith(SignatureAlgorithm.HS256, config.getSign().getBytes())
        .setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 100000)).compact();
    log.info("generar token : Bearer {}", token);
    return "Bearer " + token;
  }

}
