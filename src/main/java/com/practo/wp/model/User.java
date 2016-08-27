package com.practo.wp.model;

import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;

public class User {
  private int userId;
  private String emailId;
  private String name;
  private String mobileno;

  public User() {}

  public int getUserId() {
    return this.userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobile() {
    return mobileno;
  }

  public void setMobile(String mobileno) {
    this.mobileno = mobileno;
  }

  /**
   * .
   * 
   * @param e()
   */
  public void setData(UserEntity entity) {
    if (entity != null) {
      setUserId(entity.getUserId());
      setName(entity.getName());
      setEmailId(entity.getEmailId());
      setMobile(entity.getMobile());
    }
  }

  public UserEntity convert() {
    UserEntity et = new UserEntity();
    // System.out.println(PostedUserId());
    // System.out.println(getTripName());
    // System.out.println(getAverageCost());
    // System.out.println(getGoingDate());
    // System.out.println(getGoingPeople());
    // System.out.println(getNumOfDay());
    et.setUserId(getUserId());
    et.setName(getName());
    et.setEmailId(getEmailId());
    et.setMobile(getMobile());

    return et;
  }
}
