package com.practo.wp.model;

import com.practo.wp.data.entity.UserEntity;

public class User {
  private int userId;
  private String email_id;
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
    return email_id;
  }

  public void setEmailId(String email_id) {
    this.email_id = email_id;
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

  public UserEntity fetchData() {
    UserEntity et = new UserEntity();
    et.setMobile(getMobile());
    et.setName(getName());
    if (getEmailId() != null)
      et.setEmailId(getEmailId());
    return et;
  }

  public void setEntity(UserEntity e) {
    if (e != null) {
      setUserId(e.getUserId());
      setName(e.getName());
      setEmailId(e.getEmailId());
      setMobile(e.getMobile());
    }
  }
}
