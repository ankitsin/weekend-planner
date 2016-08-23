package com.practo.wp.service;

import com.practo.wp.data.dao.DestinationDao;
import com.practo.wp.data.dao.TripDao;
import com.practo.wp.data.dao.UserDao;
import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TripServiceImpl implements TripService {

  @Autowired
  private DestinationDao destinationDao;
  @Autowired
  private TripDao tripDao;
  @Autowired
  private UserDao userDao;

  /**
   * .
   * 
   * @param pageable ()
   * @return ()
   */
  public Iterable<Trip> fetchAll(Pageable pageable) {
    Iterable<TripEntity> entity = tripDao.getAllTrip();
    List<Trip> trip = new ArrayList<Trip>();
    for (TripEntity temp : entity) {
      System.out.println(temp);
      try {
        Trip dto = Trip.class.newInstance();
        dto.fetchTrip(temp);
        trip.add(dto);
      } catch (InstantiationException | IllegalAccessException exc) {
        System.out.printf("Exception while fetching all the trips:" + exc);
        return null;
      }
    }
    return trip;
    // return null;
  }

  @Override
  public Iterable<Trip> fetchUserData(int id) {
    // Iterable<TripEntity> entity = tripDao.findByUserUserIdAndIsDeleted(id, (byte) 0);
    // List<Trip> trip = new ArrayList<Trip>();
    // for (TripEntity temp : entity) {
    // System.out.println(temp);
    // try {
    // Trip dto = Trip.class.newInstance();
    // dto.fetchTrip(temp);
    // trip.add(dto);
    // } catch (InstantiationException | IllegalAccessException exc) {
    // System.out.printf("Exception while DAO get for ID :" + exc);
    // return null;
    // }
    // }
    // return trip;
    return null;
  }



  @Override
  public Trip create(Trip model) {
    TripEntity entity = model.post();
    UserEntity user = userDao.findUser(model.posteduserId());
    entity.setUser(user);
    DestinationEntity destination = destinationDao.findDestination(model.postedDestinationId());
    entity.setDestination(destination);
    Date date = new Date();
    entity.setCreatedAt(date);
    entity.setModifiedAt(date);
    entity = tripDao.createTrip(entity);
    model.fetchTrip(entity);
    return model;
  }

  @Override
  public Trip update(Trip model) {
    TripEntity entity = model.post();
    Date date = new Date();
    UserEntity user = userDao.findUser(model.posteduserId());
    entity.setUser(user);
    DestinationEntity destination = destinationDao.findDestination(model.postedDestinationId());
    entity.setDestination(destination);
    TripEntity trip = tripDao.findTrip(model.getTripId());
    entity.setCreatedAt(trip.getCreatedAt());
    entity.setModifiedAt(date);
    entity = tripDao.updateTrip(entity);
    model.fetchTrip(entity);
    return model;
    // TripEntity entity = model.getEntity();
    // entity = tripDao.save(entity);
    // model.mergeEntity(entity);
    // return null;
  }

  @Override
  public void delete(int tripId) {
    TripEntity entity = tripDao.findTrip(tripId);
    Date date = new Date();
    entity.setModifiedAt(date);
    entity.setIsDeleted((byte) 1);
    entity = tripDao.updateTrip(entity);
    // tripDao.delete(TripId);
  }

  /**
   * .
   * 
   * @param filter ()
   * @return ()
   */
  public Iterable<Trip> fecthOnFilter(TripFilter filter, Pageable pageable) {
    // Iterable<TripEntity> entity = tripDao.findAll(filter.toPredicate(), pageable);
    Iterable<TripEntity> entity = tripDao.getAllTrip();
    List<Trip> trip = new ArrayList<Trip>();
    for (TripEntity temp : entity) {
      System.out.println(temp);
      try {
        Trip dto = Trip.class.newInstance();
        dto.fetchTrip(temp);
        trip.add(dto);
      } catch (InstantiationException | IllegalAccessException exc) {
        System.out.printf("Exception while fetching all the trips:" + exc);
        return null;
      }
    }
    return trip;
  }

  @Override
  public Trip fetchOne(int id) {
    TripEntity entity = tripDao.findTrip(id);
    Trip dto;
    try {
      dto = Trip.class.newInstance();
      dto.fetchTrip(entity);
    } catch (InstantiationException | IllegalAccessException exc) {
      System.out.printf("Exception while DAO get for ID :" + exc);
      return null;
    }
    return dto;
  }


}
