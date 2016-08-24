package com.practo.wp.data.dao;

import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
  public void createUser(UserEntity obj) {
    template.save(obj);
  }

  @Transactional
  public void updatUser(UserEntity obj) {
    template.update(obj);
  }

  @Override
  public UserEntity findUserByEmail(String emailId) {
    DetachedCriteria criteria = DetachedCriteria.forClass(UserEntity.class);
    criteria = criteria.add(Restrictions.eq("emailId", emailId));
    Iterable<UserEntity> temp = (Iterable<UserEntity>) template.findByCriteria(criteria);
    UserEntity result = new UserEntity();
    for (UserEntity iter : temp) {
      result = iter;
    }
    // return (UserEntity) template.findByCriteria(criteria);
    return result;
  }
}
