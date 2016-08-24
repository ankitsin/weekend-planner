package com.practo.wp.data.dao;

import com.practo.wp.data.entity.DestinationEntity;


public interface DestinationDao {

  DestinationEntity findDestination(int id);

  Iterable<DestinationEntity> getAllDestination();

  DestinationEntity createDestination(DestinationEntity obj);

  DestinationEntity updatDestination(DestinationEntity obj);

  Iterable<DestinationEntity> fetchIdByName(String[] name);

  Iterable<DestinationEntity> fetchIdByType(String[] type);
}
