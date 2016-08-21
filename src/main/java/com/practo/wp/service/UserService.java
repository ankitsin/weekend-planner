package com.practo.wp.service;

import javax.transaction.Transactional;

import com.practo.wp.model.User;

public interface UserService {

  User get(Integer id);

  @Transactional
  User create(User d);

  @Transactional
  User update(User d);

//  @Transactional
//  void delete(Integer id);
}
