package com.practo.wp.model;

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
   * Convert entity {@link UserEntity} to model {@link User}.
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

  /**
   * Convert model to entity {@link UserEntity}.
   * 
   * @return entity {@link UserEntity}
   */
  public UserEntity convert() {
    UserEntity entity = new UserEntity();
    // System.out.println(PostedUserId());
    // System.out.println(getTripName());
    // System.out.println(getAverageCost());
    // System.out.println(getGoingDate());
    // System.out.println(getGoingPeople());
    // System.out.println(getNumOfDay());
    entity.setUserId(getUserId());
    entity.setName(getName());
    entity.setEmailId(getEmailId());
    entity.setMobile(getMobile());

    return entity;
  }
}
