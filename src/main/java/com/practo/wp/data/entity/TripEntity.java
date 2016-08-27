package com.practo.wp.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trip database table.
 * 
 */
@Entity
@Table(name = "trip")
@NamedQuery(name = "TripEntity.findAll", query = "SELECT t FROM TripEntity t")
public class TripEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "trip_id")
  private int tripId;

  @Column(name = "average_cost")
  private int averageCost;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at")
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "going_date")
  private Date goingDate;

  @Column(name = "going_people")
  private int goingPeople;

  @Column(name = "is_deleted")
  private byte isDeleted;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modified_at")
  private Date modifiedAt;

  @Column(name = "num_of_day")
  private int numOfDay;

  @Column(name = "space_left")
  private int spaceLeft;

  @Column(name = "trip_name")
  private String tripName;

  // bi-directional many-to-one association to SignedupEntity
  @OneToMany(mappedBy = "trip")
  private List<SignedupEntity> signedups;

  // bi-directional many-to-one association to DestinationEntity
  @ManyToOne
  @JoinColumn(name = "destination_id")
  private DestinationEntity destination;

  // bi-directional many-to-one association to UserEntity
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  public TripEntity() {}

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

  public byte getIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(byte isDeleted) {
    this.isDeleted = isDeleted;
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

  public List<SignedupEntity> getSignedups() {
    return this.signedups;
  }

  public void setSignedups(List<SignedupEntity> signedups) {
    this.signedups = signedups;
  }

  public SignedupEntity addSignedup(SignedupEntity signedup) {
    getSignedups().add(signedup);
    signedup.setTrip(this);

    return signedup;
  }

  public SignedupEntity removeSignedup(SignedupEntity signedup) {
    getSignedups().remove(signedup);
    signedup.setTrip(null);

    return signedup;
  }

  public DestinationEntity getDestination() {
    return this.destination;
  }

  public void setDestination(DestinationEntity destination) {
    this.destination = destination;
  }

  public UserEntity getUser() {
    return this.user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

}
