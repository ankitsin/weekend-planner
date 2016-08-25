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
  private Integer[] averageCost;
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

  public Integer[] getAverageCost() {
    return averageCost;
  }

  public void setAverageCost(String averageCost) {
    this.averageCost = convertStringArraytoInt(averageCost);
  }

  public Integer[] getNumOfDays() {
    return numOfDays;
  }

  public void setNumOfDays(String numOfDays) {
    this.numOfDays = convertStringArraytoInt(numOfDays);
  }


  public String[] getDestinationName() {
    return destinationName;
  }

  public void setDestinationName(String destinationName) {
    this.destinationName = destinationName.split(",");
  }

  public String[] getDestinationType() {
    return destinationType;
  }

  public void setDestinationType(String destinationType) {
    this.destinationType = destinationType.split(",");
  }


  public Integer[] getSpaceLeft() {
    return spaceLeft;
  }

  public void setSpaceLeft(String spaceLeft) {
    this.spaceLeft = convertStringArraytoInt(spaceLeft);
  }



  /**
   * .
   * 
   * @return ()
   */
  // public Predicate toPredicate() {
  // QTripEntity b1 = QTripEntity.tripEntity;
  // BooleanExpression predicate = b1.isDeleted.eq((byte) 0);
  // // BooleanExpression predicate =null;
  // if (spaceLeft != null) {
  // System.out.println(spaceLeft);
  // predicate = predicate.and(b1.spaceLeft.in(spaceLeft));
  // }
  // if (destinationName != null) {
  // System.out.println(destinationName);
  // predicate = predicate.and(b1.destination.location.in(destinationName));
  // }
  // if (destinationType != null) {
  // System.out.println(destinationType);
  // predicate = predicate.and(b1.destination.type.in(destinationType));
  // }
  // if (numOfDays != null) {
  // System.out.println(numOfDays);
  // predicate = predicate.and(b1.numOfDay.in(numOfDays));
  // }
  // if (averageCost != null) {
  // System.out.println(averageCost[0] + " " + averageCost[1]);
  // predicate = predicate.and(b1.averageCost.between(averageCost[0], averageCost[1]));
  // }
  // return predicate;
  // return null;
  // }

  private Integer[] convertStringArraytoInt(String input) {
    String[] temp = input.split(",");
    Integer[] intarray = new Integer[temp.length];
    for (int i = 0; i < temp.length; i++) {
      intarray[i] = Integer.parseInt(temp[i]);
    }
    return intarray;
  }


}
