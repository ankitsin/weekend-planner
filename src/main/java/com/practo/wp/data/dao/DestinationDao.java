package com.practo.wp.data.dao;

import com.practo.wp.data.entity.DestinationEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class DestinationDao {

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
}
