package com.practo.wp.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.practo.wp.data.dao.DestinationDao;
import com.practo.wp.data.dao.TripDao;
import com.practo.wp.data.dao.UserDao;
import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.model.Trip;

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

  public Iterable<Trip> fetchAll() {
    Iterable<TripEntity> entity = repository.findAll();
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
    Iterable<TripEntity> entity = TripDao.findByUserUserId(id);
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
    TripDao.delete(TripId);
  }

  @Override
  public Iterable<Trip> fecthOnFilter() {
//    String startDateString = "2016-08-22";
//    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//    Date startDate = null;
//    try {
//      startDate = df.parse(startDateString);
//      String newDateString = df.format(startDate);
//      System.out.println(newDateString);
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
    int going=3;
    int space=(Integer) null;
    Iterable<TripEntity> entity = TripDao.findByGoingPeopleAndSpaceLeft(going,space);
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


}
