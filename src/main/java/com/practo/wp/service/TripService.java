package com.practo.wp.service;

import javax.transaction.Transactional;

import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;

public interface TripService {
  Iterable<Trip> fetchAll();

  Iterable<Trip> fetchUserData(int id);

  Iterable<Trip> fecthOnFilter(TripFilter filter);

  @Transactional
  Trip create(Trip d);

  void delete(int id);

  Trip update(Trip d);
}
