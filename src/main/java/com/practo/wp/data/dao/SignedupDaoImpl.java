package com.practo.wp.data.dao;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.practo.wp.data.entity.SignedupEntity;


@Repository
public class SignedupDaoImpl implements SignedupDao {

  @Autowired
  private HibernateTemplate template;


  @Transactional
  public SignedupEntity findById(int id) {
    return template.load(SignedupEntity.class, id);
  }

  @Transactional
  public void create(SignedupEntity obj) {
    template.save(obj);
  }

  @Override
  public Iterable<SignedupEntity> search(int tripId, int userId) {
    DetachedCriteria criteria = DetachedCriteria.forClass(SignedupEntity.class);
    criteria = criteria.add(Restrictions.eq("user.userId", userId));
    criteria = criteria.add(Restrictions.eq("trip.tripId", tripId));
    return (Iterable<SignedupEntity>) template.findByCriteria(criteria);

  }

}
