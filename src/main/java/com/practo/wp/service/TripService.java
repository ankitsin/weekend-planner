package com.practo.wp.service;

import javax.transaction.Transactional;

import com.practo.wp.model.Trip;

public interface TripService {
  Iterable<Trip> fetchAll();

  Iterable<Trip> fetchUserData(int id);

  Iterable<Trip> fecthOnFilter();

  @Transactional
  Trip create(Trip d);

  void delete(int id);

  Trip update(Trip d);
}
