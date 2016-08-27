package com.practo.wp.data.dao;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
  public void createDestination(DestinationEntity obj) {
    template.save(obj);
  }

  @Transactional
  public void updatDestination(DestinationEntity obj) {
    template.update(obj);
  }

  @Transactional
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
  }

  @Override
  public Iterable<String> getFilters() {
    DetachedCriteria criteria = DetachedCriteria.forClass(DestinationEntity.class);
    criteria = criteria.setProjection(Projections.distinct(Projections.property("type")));
    // criteria = criteria.
    // TODO Auto-generated method stub
    return (Iterable<String>) template.findByCriteria(criteria);
  }

  @Override
  public Iterable<DestinationEntity> findDestinationByName(String name) {
    DetachedCriteria criteria = DetachedCriteria.forClass(DestinationEntity.class);
    criteria = criteria.add(Restrictions.eq("location", name));
    // criteria = criteria.
    // TODO Auto-generated method stub
    return (Iterable<DestinationEntity>) template.findByCriteria(criteria);
  }

}
