package com.practo.wp.service;

import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.User;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

public interface UserService {
  /**
   * .
   * 
   * @param id ()
   * @return ()
   */
  @Transactional
  User get(Integer id) throws MessagingException;

  @Transactional
  User getId(String emailId);
}
