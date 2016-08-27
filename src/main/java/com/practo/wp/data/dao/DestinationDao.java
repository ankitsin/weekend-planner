package com.practo.wp.data.dao;

import com.practo.wp.data.entity.DestinationEntity;


public interface DestinationDao {

  DestinationEntity findDestination(int id);

  Iterable<DestinationEntity> findDestinationByName(String name);

  Iterable<DestinationEntity> getAllDestination();

  Iterable<String> getFilters();

  void createDestination(DestinationEntity obj);

  void updatDestination(DestinationEntity obj);

  Iterable<DestinationEntity> fetchIdByName(String[] name);

  Iterable<DestinationEntity> fetchIdByType(String[] type);
}
