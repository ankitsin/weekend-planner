package com.practo.wp.data.dao;

import com.practo.wp.data.entity.UserEntity;

public interface UserDao {

  UserEntity findUser(int id);

  UserEntity createUser(UserEntity obj);

  UserEntity updatUser(UserEntity obj);

}
