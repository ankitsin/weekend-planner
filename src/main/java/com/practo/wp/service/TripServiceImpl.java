package com.practo.wp.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.practo.wp.data.dao.DestinationDao;
import com.practo.wp.data.dao.TripDao;
import com.practo.wp.data.dao.UserDao;
import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;

@Service
public class TripServiceImpl implements TripService {
  @Autowired
  private CrudRepository<TripEntity, Integer> repository;

  public CrudRepository<TripEntity, Integer> getRepository() {
    return repository;
  }

  @Autowired
  private TripDao TripDao;
  @Autowired
  private UserDao UserDao;
  @Autowired
  private DestinationDao DestinationDao;

  public Iterable<Trip> fetchAll(Pageable pageable) {
    // Iterable<TripEntity>entity= TripDao.findByIsDeleted( (byte)0,pageable);
//    Iterable<TripEntity> entity = TripDao.findAll(pageable);
    TripFilter filter=new TripFilter();
    Iterable<TripEntity> entity = TripDao.findAll(filter.toPredicate(), pageable);
    List<Trip> trip = new ArrayList<Trip>();
    for (TripEntity temp : entity) {
      System.out.println(temp);
      try {
        Trip dto = Trip.class.newInstance();
        dto.fetchTrip(temp);
        trip.add(dto);
      } catch (InstantiationException | IllegalAccessException e) {
        System.out.printf("Exception while fetching all the trips:" + e);
        return null;
      }
    }
    return trip;
  }

  @Override
  public Iterable<Trip> fetchUserData(int id) {
    System.out.println(id);
    Iterable<TripEntity> entity = TripDao.findByUserUserIdAndIsDeleted(id, (byte) 0);
    List<Trip> trip = new ArrayList<Trip>();
    for (TripEntity temp : entity) {
      System.out.println(temp);
      try {
        Trip dto = Trip.class.newInstance();
        dto.fetchTrip(temp);
        trip.add(dto);
      } catch (InstantiationException | IllegalAccessException e) {
        System.out.printf("Exception while DAO get for ID :" + e);
        return null;
      }
    }
    return trip;
  }



  @Override
  public Trip create(Trip d) {
    TripEntity entity = d.post();
    Date date = new Date();
    UserEntity user = UserDao.findOne(d.PostedUserId());
    System.out.println(d.PostedUserId());
//    System.out.println(user.getName());
    entity.setUser(user);
    DestinationEntity destination = DestinationDao.findOne(d.PostedDestinationId());
    entity.setDestination(destination);
    entity.setCreatedAt(date);
    entity.setModifiedAt(date);
    entity = TripDao.save(entity);
    d.fetchTrip(entity);
    return d;
  }

  @Override
  public Trip update(Trip d) {
    TripEntity entity = d.post();
    Date date = new Date();
    UserEntity user = UserDao.findOne(d.PostedUserId());
    entity.setUser(user);
    DestinationEntity destination = DestinationDao.findOne(d.PostedDestinationId());
    entity.setDestination(destination);
    TripEntity trip = TripDao.findOne(d.getTripId());
    entity.setCreatedAt(trip.getCreatedAt());
    entity.setModifiedAt(date);
    entity = TripDao.save(entity);
    d.fetchTrip(entity);
    return d;
    // TripEntity entity = d.getEntity();
    // entity = TripDao.save(entity);
    // d.mergeEntity(entity);
    // return null;
  }

  @Override
  public void delete(int TripId) {
    TripEntity entity = TripDao.findOne(TripId);
    Date date = new Date();
    entity.setModifiedAt(date);
    entity.setIsDeleted((byte) 1);
    entity = TripDao.save(entity);
    // TripDao.delete(TripId);
  }

  public Iterable<Trip> fecthOnFilter(TripFilter filter, Pageable pageable) {
    Iterable<TripEntity> entity = TripDao.findAll(filter.toPredicate(), pageable);
    // Iterable<TripEntity> entity = TripDao.findAll();
    List<Trip> trip = new ArrayList<Trip>();
    for (TripEntity temp : entity) {
      System.out.println(temp);
      try {
        Trip dto = Trip.class.newInstance();
        dto.fetchTrip(temp);
        trip.add(dto);
      } catch (InstantiationException | IllegalAccessException e) {
        System.out.printf("Exception while fetching all the trips:" + e);
        return null;
      }
    }
    return trip;
  }

  @Override
  public Trip fetchOne(int id) {
    // TODO Auto-generated method stub
    TripEntity entity = TripDao.findOne(id);
    Trip dto;
    try {
      dto = Trip.class.newInstance();
      dto.fetchTrip(entity);
    } catch (InstantiationException | IllegalAccessException e) {
      System.out.printf("Exception while DAO get for ID :" + e);
      return null;
    }
    return dto;
  }


}
