package com.practo.wp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Show exception messages on finding exception.
 * 
 * @author ankit
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExceptionMessageThrow extends Exception {

  /**
   * serialVersionUID of exception Message.
   */
  private static final long serialVersionUID = 1L;

  public ExceptionMessageThrow(String message) {
    // TODO Auto-generated constructor stub
    super(message);
  }
}
