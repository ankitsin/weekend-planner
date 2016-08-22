package com.practo.wp.service;

import javax.transaction.Transactional;

import com.practo.wp.model.Destination;

public interface DestinationService {
  @Transactional
  Iterable<Destination> getall();
  @Transactional
  Destination getById(Integer id);

}
