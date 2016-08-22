package com.practo.wp.model;

import com.practo.wp.data.entity.DestinationEntity;

public class Destination {
  private int destinationId;

  private int distance;

  private String location;

  private String type;
  public int getDestinationId() {
    return this.destinationId;
  }

  public void setDestinationId(int destinationId) {
    this.destinationId = destinationId;
  }

  public int getDistance() {
    return this.distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public String getLocation() {
    return this.location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setData(DestinationEntity e) {
    if (e != null) {
      setDestinationId(e.getDestinationId());
      setLocation(e.getLocation());
      setType(e.getType());
      setDistance(e.getDistance());
    }
  }
}
