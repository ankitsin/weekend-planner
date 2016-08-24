package com.practo.wp.data.dao;

import com.practo.wp.data.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao {
  @Autowired
  private HibernateTemplate template;


  @Transactional
  public UserEntity findUser(int id) {
    return template.load(UserEntity.class, id);
  }

  @Transactional
  public UserEntity createUser(UserEntity obj) {
    return (UserEntity) template.save(obj);
  }

  @Transactional
  public UserEntity updatUser(UserEntity obj) {
    template.update(obj);
    return obj;
  }
}
