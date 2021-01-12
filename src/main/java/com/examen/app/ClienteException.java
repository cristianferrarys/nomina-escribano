package com.examen.app;

import lombok.Getter;

public class ClienteException extends Exception {

  @Getter
  public final String errorCode;

  public ClienteException(final String message) {
    super(message);
    this.errorCode = null;
  }

  public ClienteException(final String message, final String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public ClienteException(final String message, final Throwable cause) {
    super(message, cause);
    this.errorCode = null;
  }

  public ClienteException(final String message, final String errorCode, final Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }
  
}
