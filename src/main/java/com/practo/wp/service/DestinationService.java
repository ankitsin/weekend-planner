package com.practo.wp.service;

import com.practo.wp.model.Destination;

import org.springframework.transaction.annotation.Transactional;



public interface DestinationService {
  Iterable<Destination> getall();

  @Transactional
  Iterable<String> getFilters();

  @Transactional
  Destination getById(Integer id);

  @Transactional
  Destination getId(String destination);

}
