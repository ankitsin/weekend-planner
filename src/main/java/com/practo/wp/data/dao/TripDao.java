package com.practo.wp.data.dao;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.practo.wp.data.entity.TripEntity;

@SuppressWarnings("unused")
public interface TripDao extends  CrudRepository<TripEntity, Integer>{
  Iterable<TripEntity> findByGoingPeopleAndSpaceLeft(int goingdate,int space);
  @Transactional
  Iterable<TripEntity> findByUserUserId(int id);
}
