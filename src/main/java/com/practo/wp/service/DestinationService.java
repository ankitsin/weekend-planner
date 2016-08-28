package com.practo.wp.service;

import com.practo.wp.model.Destination;

public interface DestinationService {
  Iterable<Destination> getall();

  Iterable<String> getFilters();

  Destination getByName(String name);

  Destination getById(Integer id);

  Destination getId(String destination);

  void createDestination(Destination destination);

  void updateDestination(Destination destination);

}
