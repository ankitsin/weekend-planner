package com.practo.wp.service;

import com.practo.wp.model.User;

import javax.transaction.Transactional;

public interface UserService {
  /**
   * .
   * 
   * @param id ()
   * @return ()
   */
  @Transactional
  User get(Integer id);
}
