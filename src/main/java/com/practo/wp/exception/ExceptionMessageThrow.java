package com.practo.wp.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.practo.wp.run.Application;

/**
 * Show exception messages on finding exception.
 * 
 * @author ankit
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExceptionMessageThrow extends Exception {
  private static final Logger logger = LogManager.getLogger(Application.class);

  /**
   * serialVersionUID of exception Message.
   */
  private static final long serialVersionUID = 1L;

  /**
   * .
   * 
   * @param message ()
   */
  public ExceptionMessageThrow(String message) {
    super(message);
    logger.error(message);
    // TODO Auto-generated constructor stub

  }
}
