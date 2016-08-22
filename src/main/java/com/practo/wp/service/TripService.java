package com.practo.wp.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;

import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;

public interface TripService {
  Iterable<Trip> fetchAll(Pageable pageable);

  Iterable<Trip> fetchUserData(int id);

  Iterable<Trip> fecthOnFilter(TripFilter filter,Pageable pagebale);
  
  Trip fetchOne(int id);
  @Transactional
  Trip create(Trip d);
  
  void delete(int id);

  Trip update(Trip d);
}
