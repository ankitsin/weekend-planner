package com.practo.wp.service;

import com.practo.wp.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

public interface UserService {
  /**
   * User service for getting user information based on id, email id and creating a new user when a
   * user login for the first time.
   * 
   * @param id ()
   * @return ()
   */
  @Transactional
  User get(Integer id) throws MessagingException;

  @Transactional
  User getId(String emailId);

  User createUser(User user);
}
