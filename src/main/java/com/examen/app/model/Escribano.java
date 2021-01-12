package com.examen.app.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Escribano implements Serializable {
  private Long cuil;
  private String nombre;
  private String apellido;
  private int matricula;
  private String telefono;
  private String email;
  private String estado;
  private static final long serialVersionUID = -6835203189583689162L;
}
