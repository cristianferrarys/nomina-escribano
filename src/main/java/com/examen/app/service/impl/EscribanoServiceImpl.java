package com.examen.app.service.impl;

import com.examen.app.ClienteException;
import com.examen.app.config.ConfigAutenticacion;
import com.examen.app.config.JwtConfig;
import com.examen.app.model.Escribano;
import com.examen.app.service.EscribanoService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Slf4j
@Service
public class EscribanoServiceImpl implements EscribanoService {

  @Autowired
  private JwtConfig jwt;

  @Autowired
  private ConfigAutenticacion config;

  @Override
  public Escribano getEscribano(final Long cuit) throws ClienteException  {
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      headers.set("Authorization", jwt.getToken());

      HttpEntity<String> entity = new HttpEntity<String>(headers);

      final URI uri = UriComponentsBuilder.fromUriString(config.getUrl()).path("/escribano/estado/{cuit}").buildAndExpand(cuit).toUri();
      log.info("url: {}", uri);
      ResponseEntity<Escribano> response = restTemplate.exchange(uri, HttpMethod.GET, entity, Escribano.class);
      log.info("info {}", response.getBody());
      return response.getBody();
  }
}
