package com.practo.wp.data.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.practo.wp.data.entity.TripEntity;

@SuppressWarnings("unused")
public interface TripDao extends PagingAndSortingRepository<TripEntity, Integer>,QueryDslPredicateExecutor<TripEntity> {

  
 TripEntity findByTripIdAndIsDeleted(int id, byte t);

  @Transactional
  Iterable<TripEntity> findByGoingPeopleAndSpaceLeft(int goingdate, int space);

  @Transactional
  Iterable<TripEntity> findByUserUserIdAndIsDeleted(int id, byte t);

  @Transactional
  Iterable<TripEntity> findByTripName(String name);
}
