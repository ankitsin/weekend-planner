package com.practo.wp.service;

import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;

import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;



public interface TripService {

  Iterable<Trip> fetchAll(Pageable pageable);

  Iterable<Trip> fetchUserData(int id);


  Iterable<Trip> fecthOnFilter(TripFilter filter, Pageable pagebale);

  Trip fetchOne(int id);

  @Transactional
  Trip create(Trip entity);

  void delete(int id);

  Trip update(Trip entity);
}
