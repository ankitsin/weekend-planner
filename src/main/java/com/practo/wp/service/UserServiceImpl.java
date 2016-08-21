package com.practo.wp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.model.User;

@Service
public class UserServiceImpl implements UserService {

  @Autowired

  private CrudRepository<UserEntity, Integer> repository;

  public CrudRepository<UserEntity, Integer> getRepository() {
    return repository;
  }

  public User get(Integer id) {
    UserEntity entity = repository.findOne(id);
    try {
      User dto = User.class.newInstance();
      dto.setEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      System.out.printf("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  public User create(User d) {
    UserEntity entity = d.fetchData();
    entity = repository.save(entity);
    d.setEntity(entity);
    return d;
  }

  public User update(User d) {
    UserEntity entity = d.fetchData();
    entity = repository.save(entity);
    d.setEntity(entity);
    return d;
  }

  public void delete(Integer id) {
    repository.delete(id);
  }



}
