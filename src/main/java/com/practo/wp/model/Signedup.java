package com.practo.wp.model;

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

  /**
   * Convert entity to model.
   * 
   * @param entity {@link TripEntity}
   */
  public void setData(SignedupEntity entity) {
    if (entity != null) {
      setId(entity.getId());
      setTrip(entity.getTrip());
      setUser(entity.getUser());
    }
  }

}
