package com.practo.wp.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private int userId;

  @Column(name = "email_id")
  private String emailId;

  private String mobile;

  private String name;

  // bi-directional many-to-one association to TripEntity
  @OneToMany(mappedBy = "user")
  private List<TripEntity> trips;

  // bi-directional many-to-one association to SignedupEntity
  @OneToMany(mappedBy = "user")
  private List<SignedupEntity> signedups;

  public UserEntity() {}

  public int getUserId() {
    return this.userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getEmailId() {
    return this.emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getMobile() {
    return this.mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TripEntity> getTrips() {
    return this.trips;
  }

  public void setTrips(List<TripEntity> trips) {
    this.trips = trips;
  }

  public TripEntity addTrip(TripEntity trip) {
    getTrips().add(trip);
    trip.setUser(this);

    return trip;
  }

  public TripEntity removeTrip(TripEntity trip) {
    getTrips().remove(trip);
    trip.setUser(null);

    return trip;
  }

  public List<SignedupEntity> getSignedups() {
    return this.signedups;
  }

  public void setSignedups(List<SignedupEntity> signedups) {
    this.signedups = signedups;
  }

  public SignedupEntity addSignedup(SignedupEntity signedup) {
    getSignedups().add(signedup);
    signedup.setUser(this);

    return signedup;
  }

  public SignedupEntity removeSignedup(SignedupEntity signedup) {
    getSignedups().remove(signedup);
    signedup.setUser(null);

    return signedup;
  }

}
