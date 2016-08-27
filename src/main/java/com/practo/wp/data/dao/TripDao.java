package com.practo.wp.data.dao;

import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.model.TripFilter;

import org.springframework.data.domain.Pageable;



public interface TripDao {

  TripEntity findTrip(int tripId);

  Iterable<TripEntity> getAllTrip();

  void createTrip(TripEntity obj);

  void updateTrip(TripEntity obj);


  Iterable<TripEntity> findTripAndNotDeleted(Pageable pageable);


  Iterable<TripEntity> findTripOnFilter(TripFilter filter, Pageable pageable);
  //
  // @Transactional
  // Iterable<TripEntity> findByGoingPeopleAndSpaceLeft(int goingdate, int space);
  //
  // @Transactional
  // Iterable<TripEntity> findByUserUserIdAndIsDeleted(int id, byte isDel);
  //
  // @Transactional
  // Iterable<TripEntity> findByTripName(String name);

  // String getPages();
}
