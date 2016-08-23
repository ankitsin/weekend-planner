package com.practo.wp.data.dao;

import com.practo.wp.data.entity.TripEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class TripDao {

  @Autowired
  private HibernateTemplate template;

  @Transactional
  public TripEntity findTrip(int tripId) {
    return template.load(TripEntity.class, tripId);
  }

  @Transactional
  public Iterable<TripEntity> getAllTrip() {
    return template.loadAll(TripEntity.class);
  }

  @Transactional
  public TripEntity createTrip(TripEntity obj) {
    return (TripEntity) template.save(obj);
  }

  @Transactional
  public TripEntity updateTrip(TripEntity obj) {
    template.update(obj);
    return obj;
  }
  // @Transactional
  // public TripEntity findByTripIdAndIsDeleted(int id, byte isDel);
  //
  // @Transactional
  // Iterable<TripEntity> findByGoingPeopleAndSpaceLeft(int goingdate, int space);
  //
  // @Transactional
  // Iterable<TripEntity> findByUserUserIdAndIsDeleted(int id, byte isDel);
  //
  // @Transactional
  // Iterable<TripEntity> findByTripName(String name);
}
