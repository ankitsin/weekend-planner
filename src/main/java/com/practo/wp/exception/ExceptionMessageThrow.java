package com.practo.wp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExceptionMessageThrow extends Exception {

  private static final long serialVersionUID = -570050669946005424L;

  public ExceptionMessageThrow(String message) {
    // TODO Auto-generated constructor stub
    super(message);
  }
}
