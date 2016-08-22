package com.practo.wp.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.wp.data.dao.DestinationDao;
import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.model.Destination;
import com.practo.wp.model.Trip;


@Service
public class DestinationServiceImpl implements DestinationService {
  
  @Autowired
  private DestinationDao DestDao;

  @Override
  public Iterable<Destination> getall() {
    Iterable<DestinationEntity> entity =  DestDao.findAll();
    List<Destination> destination = new ArrayList<Destination>();
    for (DestinationEntity temp : entity) {
      System.out.println(temp);
      try {
        Destination dto = Destination.class.newInstance();
        dto.setData(temp);
        destination.add(dto);
      } catch (InstantiationException | IllegalAccessException e) {
        System.out.printf("Exception while fetching all the trips:" + e);
        return null;
      }
    }
    return destination;
//    try {
//      Destination dto = Destination.class.newInstance();
//      dto.setData(entity);
//      return dto;
//    } catch (InstantiationException | IllegalAccessException e) {
//      System.out.printf("Exception while DAO get for ID :", e);
//      return null;
//    }
  }
  
  @Override
  public Destination getById(Integer id) {
    DestinationEntity entity = DestDao.findOne(id);
    try {
      Destination dto = Destination.class.newInstance();
      dto.setData(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      System.out.printf("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }
}


