package com.practo.wp.service;

import com.practo.wp.data.dao.DestinationDao;
import com.practo.wp.data.dao.SignedupDao;
import com.practo.wp.data.dao.TripDao;
import com.practo.wp.data.dao.UserDao;
import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.SignedupEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;
import com.practo.wp.model.User;
import com.practo.wp.utility.mailSendUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

@Service
@Transactional
public class TripServiceImpl implements TripService {

  @Autowired
  private DestinationDao destinationDao;
  @Autowired
  private TripDao tripDao;
  @Autowired
  private UserDao userDao;
  @Autowired
  private SignedupDao signedupDao;
  @Autowired
  private mailSendUtility smtpMailSender;

  /**
   * .
   * 
   * @param pageable ()
   * @return ()
   */
  public Iterable<Trip> fetchAll(Pageable pageable) {
    Iterable<TripEntity> entity = tripDao.findTripAndNotDeleted(pageable);
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
  public Trip signUpForTrip(String tripId, String emailId) throws MessagingException {
    // String[] temp = tripIdemailId.split(",");
    // String tripId = temp[0];
    // String emailId = temp[1];

    TripEntity entity = tripDao.findTrip(Integer.parseInt(tripId));
    Trip model = new Trip();
    model.fetchTrip(entity);
    // UserEntity postedUser = entity.getUser();
    UserEntity signedUpUser = userDao.findUserByEmail(emailId);
    Iterable<SignedupEntity> var =
        signedupDao.search(Integer.parseInt(tripId), signedUpUser.getUserId());
    System.out.println(
        Integer.parseInt(tripId) + " " + signedUpUser.getUserId() + "@@@@@@@@@@@@@@@@@@@@@" + var);
    if (entity.getSpaceLeft() > 0 && !var.iterator().hasNext()) {

      entity.setGoingPeople(entity.getGoingPeople() + 1);
      entity.setSpaceLeft(entity.getSpaceLeft() - 1);
      tripDao.updateTrip(entity);
      // model.fetchTrip(newEntity);

      SignedupEntity signEntity = new SignedupEntity();
      signEntity.setTrip(tripDao.findTrip(Integer.parseInt(tripId)));
      signEntity.setUser(signedUpUser);
      signedupDao.create(signEntity);
      String location = model.getDestinationLocation();
      smtpMailSender.send(emailId, "Signed up for Trip: " + entity.getTripName(),
          "You have signed up for trip : " + entity.getTripName() + " with destination : "
              + location + "  on date: " + entity.getGoingDate());

      smtpMailSender.send(entity.getUser().getEmailId(),
          signedUpUser.getName() + " signed for Trip: " + entity.getTripName(),
          signedUpUser.getName() + "( " + signedUpUser.getEmailId() + "," + signedUpUser.getMobile()
              + ") has signed up for trip :" + entity.getTripName() + " with destination : "
              + location + "  dated on: " + entity.getGoingDate());


      return model;
    }
    return null;

  }



  @Override
  public Trip create(Trip model) throws ExceptionMessageThrow {
    DestinationEntity destination = destinationDao.findDestination(model.postedDestinationId());
    System.out.println(destination.getLocation() + " Posted destination name");
    System.out.println(destination.getType() + " Posted destination name");
    System.out.println(destination.getDestinationId() + " Posted destination name");
    UserEntity user = userDao.findUser(model.posteduserId());
    System.out.println(user.getEmailId() + " Posted User email id");
    TripEntity entity = model.post();
    System.out.println(model.getGoingDate() + " Posted destination name");
    entity.setUser(user);
    System.out.println(model.getGoingDate() + " Posted destination name");
    entity.setDestination(destination);
    Date date = new Date();
    System.out.println(model.getGoingDate() + " Posted destination name");
    entity.setCreatedAt(date);
    System.out.println(model.getGoingDate() + " Posted destination name");
    entity.setModifiedAt(date);
    System.out.println(date + " Date destination name");
    tripDao.createTrip(entity);
    System.out.println(date + " Date destination name");
    model.fetchTrip(entity);
    return model;
  }

  @Override
  public Trip update(Trip model) throws ExceptionMessageThrow {
    TripEntity entity = model.post();
    Date date = new Date();
    UserEntity user = userDao.findUser(model.posteduserId());
    entity.setUser(user);
    DestinationEntity destination = destinationDao.findDestination(model.postedDestinationId());
    entity.setDestination(destination);
    TripEntity trip = tripDao.findTrip(model.getTripId());
    entity.setCreatedAt(trip.getCreatedAt());
    entity.setModifiedAt(date);
    tripDao.updateTrip(entity);
    model.fetchTrip(entity);
    return model;
    // TripEntity entity = model.getEntity();
    // entity = tripDao.save(entity);
    // model.mergeEntity(entity);
    // return null;
  }

  @Override
  public String delete(int tripId) throws ExceptionMessageThrow {
    TripEntity entity = tripDao.findTrip(tripId);
    Date date = new Date();
    entity.setModifiedAt(date);
    entity.setIsDeleted((byte) 1);
    tripDao.updateTrip(entity);
    return "Operation done successfully";
  }

  /**
   * .
   * 
   * @param filter ()
   * @return ()
   */
  public Iterable<Trip> fecthOnFilter(TripFilter filter, Pageable pageable) {
    Iterable<TripEntity> entity = tripDao.findTripOnFilter(filter, pageable);
    // Iterable<TripEntity> entity = tripDao.getAllTrip();
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

  // @Override
  // public String getTotalPage() {
  // String page = tripDao.getPages();
  // return null;
  // }


}
