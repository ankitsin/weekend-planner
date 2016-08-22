package com.practo.wp.model;

import java.util.Date;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;

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
    System.out.print(userId);
    this.postedUserId = userId;
  }

  public int PostedUserId() {
    return this.postedUserId;
  }

  public void setPostedDestinationId(int destinationId) {
    this.posteDestinationId = destinationId;
  }

  public int PostedDestinationId() {
    return this.posteDestinationId;
  }

  public void fetchTrip(TripEntity e) {
    if (e != null) {
      setTripId(e.getTripId());
      setTripName(e.getTripName());
      setAverageCost(e.getAverageCost());
      setGoingDate(e.getGoingDate());
      setGoingPeople(e.getGoingPeople());
      setSpaceLeft(e.getSpaceLeft());
      setUser(e.getUser());
      setDestination(e.getDestination());
      // System.out.println(e.getTripName());
      // System.out.println(e.getAverageCost());
      // System.out.println(e.getGoingDate());
      // System.out.println(e.getGoingPeople());
      // System.out.println(e.getUser().getName());

    }
  }

  public TripEntity post() {
    TripEntity et = new TripEntity();
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
    if (new Integer(getTripId()) != null)
      et.setTripId(getTripId());
    return et;

  }


}
