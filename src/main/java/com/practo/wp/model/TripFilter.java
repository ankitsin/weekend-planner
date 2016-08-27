package com.practo.wp.model;

import java.util.Date;

/**
 * .
 * 
 * @author ankit
 *
 */
public class TripFilter {
  private Integer[] spaceLeft;
  private String[] destinationName;
  private String[] destinationType;
  private Integer averageCost;
  private Integer[] numOfDays;
  private String startDate;
  private String endDate;

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @SuppressWarnings("unused")
  private byte isdelete = (byte) 0;

  public Integer getAverageCost() {
    return averageCost;
  }

  public void setAverageCost(String averageCost) {
    // if (averageCost != null & averageCost != "") {
    // this.averageCost = convertStringArraytoInt(averageCost);
    // } else {
    this.averageCost = Integer.parseInt(averageCost);
  }


  public Integer[] getNumOfDays() {
    return numOfDays;
  }

  public void setNumOfDays(String numOfDays) {
    if (numOfDays != null & numOfDays != "") {
      this.numOfDays = convertStringArraytoInt(numOfDays);
    } else {
      this.numOfDays = new Integer[0];
    }

  }


  public String[] getDestinationName() {
    return destinationName;
  }

  public void setDestinationName(String destinationName) {
    if (destinationName != null & destinationName != "") {
      this.destinationName = destinationName.split(",");
    } else {
      this.destinationName = new String[0];
    }
  }

  public String[] getDestinationType() {
    return destinationType;
  }

  public void setDestinationType(String destinationType) {
    if (destinationType != null && destinationType != "") {
      this.destinationType = destinationType.split(",");
    } else {
      this.destinationType = new String[0];
    }
  }


  public Integer[] getSpaceLeft() {
    return spaceLeft;
  }

  public void setSpaceLeft(String spaceLeft) {
    if (spaceLeft != null && spaceLeft != "") {
      this.spaceLeft = convertStringArraytoInt(spaceLeft);
    } else {
      this.spaceLeft = new Integer[0];
    }

  }

  private Integer[] convertStringArraytoInt(String input) {
    String[] temp = input.split(",");
    Integer[] intarray = new Integer[temp.length];
    for (int i = 0; i < temp.length; i++) {
      intarray[i] = Integer.parseInt(temp[i]);
      System.out.println(intarray[i]);
    }
    return intarray;
  }


}
