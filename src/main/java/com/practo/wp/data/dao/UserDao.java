package com.practo.wp.data.dao;

import com.practo.wp.data.entity.UserEntity;

public interface UserDao {

  UserEntity findUser(int id);

  UserEntity findUserByEmail(String emailId);

  UserEntity createUser(UserEntity obj);

  UserEntity updatUser(UserEntity obj);

}
