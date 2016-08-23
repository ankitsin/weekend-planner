package com.practo.wp.service;

import com.practo.wp.model.Destination;

import javax.transaction.Transactional;



public interface DestinationService {
  @Transactional
  Iterable<Destination> getall();

  @Transactional
  Destination getById(Integer id);

}
