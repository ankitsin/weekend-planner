package com.practo.wp.service;


import com.practo.wp.data.dao.DestinationDao;
import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.model.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Destination.
 * 
 * @author ankit
 *
 */
@Service
@Transactional
public class DestinationServiceImpl implements DestinationService {

  @Autowired
  private DestinationDao destinationDao;

  @Override
  public Iterable<Destination> getall() {
    Iterable<DestinationEntity> entity = destinationDao.getAllDestination();
    List<Destination> destination = new ArrayList<Destination>();
    for (DestinationEntity temp : entity) {
      try {
        Destination dto = Destination.class.newInstance();
        dto.setData(temp);
        destination.add(dto);
      } catch (InstantiationException | IllegalAccessException exc) {
        System.out.printf("Exception while fetching all the trips:" + exc);
        return null;
      }
    }
    return destination;
  }

  @Override
  public Destination getById(Integer id) {
    DestinationEntity entity = destinationDao.findDestination(id);
    try {
      Destination dto = Destination.class.newInstance();
      dto.setData(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException exc) {
      System.out.printf("Exception while DAO get for ID :" + id, exc);
      return null;
    }
  }

  @Override
  public Iterable<String> getFilters() {
    Iterable<String> filter = destinationDao.getFilters();
    return filter;
  }
}


