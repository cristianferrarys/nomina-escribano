package com.examen.app.service;

import com.examen.app.ClienteException;
import com.examen.app.model.Escribano;

public interface EscribanoService {

  Escribano getEscribano(Long cuit) throws ClienteException;

}
