package com.practo.wp.model;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;

import java.util.Date;



public class Trip {

  private int tripId;
  private int averageCost;
  private Date createdAt;
  private Date goingDate;
  private int goingPeople;
  private Date modifiedAt;
  private int numOfDay;
  private int spaceLeft;
  private String tripName;
  private UserEntity user;
  private DestinationEntity destination;
  private int postedUserId;
  private int posteDestinationId;
  private byte isDeleted;

  public int getTripId() {
    return this.tripId;
  }

  public void setTripId(int tripId) {
    this.tripId = tripId;
  }

  public int getAverageCost() {
    return this.averageCost;
  }

  public void setAverageCost(int averageCost) {
    this.averageCost = averageCost;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getGoingDate() {
    return this.goingDate;
  }

  public void setGoingDate(Date goingDate) {
    this.goingDate = goingDate;
  }

  public int getGoingPeople() {
    return this.goingPeople;
  }

  public void setGoingPeople(int goingPeople) {
    this.goingPeople = goingPeople;
  }

  public Date getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public int getNumOfDay() {
    return this.numOfDay;
  }

  public void setNumOfDay(int numOfDay) {
    this.numOfDay = numOfDay;
  }

  public int getSpaceLeft() {
    return this.spaceLeft;
  }

  public void setSpaceLeft(int spaceLeft) {
    this.spaceLeft = spaceLeft;
  }

  public String getTripName() {
    return this.tripName;
  }

  public void setTripName(String tripName) {
    this.tripName = tripName;
  }

  public String getUserName() {
    return this.user.getName();
  }

  public int getUserId() {
    return this.user.getUserId();
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public String getDestinationLocation() {
    return this.destination.getLocation();
  }

  public byte getIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(byte isDeleted) {
    this.isDeleted = isDeleted;
  }

  public void setDestination(DestinationEntity destination) {
    this.destination = destination;
  }

  // public DestinationEntity getDestination() {
  // return this.destination;
  // }

  public void setPostedUserId(int userId) {
    System.out.println(userId + "#################");
    this.postedUserId = userId;
  }

  /**
   * . @return()
   */
  public int posteduserId() {
    return this.postedUserId;
  }

  public void setPostedDestinationId(int destinationId) {
    this.posteDestinationId = destinationId;
  }

  public int postedDestinationId() {
    return this.posteDestinationId;
  }

  /**
   * .
   * 
   * @param entity()
   */
  public void fetchTrip(TripEntity entity) {
    if (entity != null) {
      setTripId(entity.getTripId());
      setTripName(entity.getTripName());
      setAverageCost(entity.getAverageCost());
      setGoingDate(entity.getGoingDate());
      setGoingPeople(entity.getGoingPeople());
      setSpaceLeft(entity.getSpaceLeft());
      setUser(entity.getUser());
      setDestination(entity.getDestination());
      // System.out.println(entity.getTripName());
      // System.out.println(entity.getAverageCost());
      // System.out.println(entity.getGoingDate());
      // System.out.println(entity.getGoingPeople());
      // System.out.println(entity.getUser().getName());

    }
  }

  /**
   * .
   * 
   * @return()
   */
  public TripEntity post() {
    TripEntity et = new TripEntity();
    // System.out.println(PostedUserId());
    // System.out.println(getTripName());
    // System.out.println(getAverageCost());
    // System.out.println(getGoingDate());
    // System.out.println(getGoingPeople());
    // System.out.println(getNumOfDay());
    et.setTripName(getTripName());
    et.setAverageCost(getAverageCost());
    et.setGoingDate(getGoingDate());
    et.setGoingPeople(getGoingPeople());
    et.setNumOfDay(getNumOfDay());
    if (new Integer(getTripId()) != null) {
      et.setTripId(getTripId());
    }
    return et;

  }


}
