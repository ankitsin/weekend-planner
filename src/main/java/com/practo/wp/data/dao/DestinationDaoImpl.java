package com.practo.wp.data.dao;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class DestinationDaoImpl implements DestinationDao {
  @Autowired
  private HibernateTemplate template;

  @Transactional
  public DestinationEntity findDestination(int id) {
    return template.load(DestinationEntity.class, id);
  }

  @Transactional
  public Iterable<DestinationEntity> getAllDestination() {
    return template.loadAll(DestinationEntity.class);
  }

  @Transactional
  public DestinationEntity createDestination(DestinationEntity obj) {
    return (DestinationEntity) template.save(obj);
  }

  @Transactional
  public DestinationEntity updatDestination(DestinationEntity obj) {
    template.update(obj);
    return obj;
  }

  @Override
  public Iterable<DestinationEntity> fetchIdByName(String[] name) {
    // TODO Auto-generated method stub
    DetachedCriteria criteria = DetachedCriteria.forClass(DestinationEntity.class);
    criteria = criteria.add(Restrictions.in("location", name));
    return (Iterable<DestinationEntity>) template.findByCriteria(criteria);
    // return null;
  }

  @Override
  public Iterable<DestinationEntity> fetchIdByType(String[] type) {
    // TODO Auto-generated method stub
    DetachedCriteria criteria = DetachedCriteria.forClass(DestinationEntity.class);
    criteria = criteria.add(Restrictions.in("type", type));
    return (Iterable<DestinationEntity>) template.findByCriteria(criteria);
//    return null;
  }

}
