package com.practo.wp.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

  /**
   * .
   * 
   * @param trip ()
   * @return ()
   */
  public TripEntity addTrip(TripEntity trip) {
    getTrips().add(trip);
    trip.setUser(this);

    return trip;
  }

  /**
   * .
   * 
   * @param trip ()
   * @return ()
   */
  public TripEntity removeTrip(TripEntity trip) {
    getTrips().remove(trip);
    trip.setUser(null);

    return trip;
  }

}
