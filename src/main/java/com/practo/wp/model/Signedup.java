package com.practo.wp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.SignedupEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;

public class Signedup {
  private int id;
  private TripEntity trip;
  private UserEntity user;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public TripEntity getTrip() {
    return this.trip;
  }

  public void setTrip(TripEntity trip) {
    this.trip = trip;
  }

  public UserEntity getUser() {
    return this.user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public void setData(SignedupEntity entity) {
    if (entity != null) {
      setId(entity.getId());
      setTrip(entity.getTrip());
      setUser(entity.getUser());
    }
  }

}
