package com.practo.wp.service;

import com.practo.wp.data.dao.UserDao;
import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Service implementation for for getting user detail using emailId and Id, creation of user,
 * update user details.
 * 
 * @author ankit
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  /**
   * User service for getting user information based on id, email id and creating a new user when a
   * user login for the first time.
   * 
   * @param id user registered id
   * @return {@link User}
   */
  public User get(Integer id) {
    UserEntity entity = userDao.findUser(id);
    try {
      User dto = User.class.newInstance();
      dto.setData(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException exc) {
      System.out.printf("Exception while DAO get for ID :" + id, exc);
      return null;
    }
  }

  @Override
  public User getByEmailId(String emailId) {
    UserEntity entity = userDao.findUserByEmail(emailId);
    User dto;
    try {
      dto = User.class.newInstance();
      dto.setData(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException exc) {
      exc.printStackTrace();
      return null;
    }

  }

  @Override
  public User createUser(User user) {
    UserEntity entity = user.convert();
    userDao.createUser(entity);
    return null;
  }

  /**
   * This is to update the user enitity.
   * 
   * @param user {@link User} model
   * @return null
   */
  public User upadteUser(User user) {
    UserEntity entity = user.convert();
    userDao.updatUser(entity);
    return user;
  }

}
