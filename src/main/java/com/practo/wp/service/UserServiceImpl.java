package com.practo.wp.service;

import com.practo.wp.data.dao.UserDao;
import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.User;
import javax.mail.MessagingException;
import com.practo.wp.utility.mailSendUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;
  // private CrudRepository<UserEntity, Integer> repository;
  //
  // public CrudRepository<UserEntity, Integer> getRepository() {
  // return repository;
  // }
  @Autowired
  private mailSendUtility smtpMailSender;

  /**
   * .
   * 
   * @param id ()
   * @return ()
   */
  public User get(Integer id) throws MessagingException {
    UserEntity entity = userDao.findUser(id);
    System.out.println("#################");
    try {
      User dto = User.class.newInstance();
      dto.setData(entity);
      smtpMailSender.send(dto.getEmailId(), "Test mail from Spring", "Howdy");
      return dto;
    } catch (InstantiationException | IllegalAccessException exc) {
      System.out.printf("Exception while DAO get for ID :" + id, exc);
      return null;
    }
  }


}
