package com.practo.wp.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.practo.wp.data.entity.UserEntity;


public interface UserDao extends CrudRepository<UserEntity, Integer>{
  
  Iterable<UserEntity> findByMobile(String mobile);

}
