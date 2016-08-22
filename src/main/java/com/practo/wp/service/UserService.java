package com.practo.wp.service;

import javax.transaction.Transactional;

import com.practo.wp.model.User;

public interface UserService {
@Transactional
  User get(Integer id);
}
