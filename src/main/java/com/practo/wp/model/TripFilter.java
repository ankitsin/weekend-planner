package com.practo.wp.model;

import com.practo.wp.data.entity.QTripEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class TripFilter {
  private Integer[] spaceLeft;
  private String[] destinationName;
  private String[] destinationType=null;
  private Integer[] averageCost=null;
  private Integer[] numOfDays;
  
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

  
  
  
  public Predicate toPredicate() {

    QTripEntity b1 = QTripEntity.tripEntity;
    BooleanExpression predicate = b1.isDeleted.eq((byte)0);
//    BooleanExpression predicate =null;
    System.out.println(spaceLeft);
    if (spaceLeft != null) {
      System.out.println(spaceLeft);
      predicate = predicate.and(b1.spaceLeft.in(spaceLeft));
    }
    if (destinationName != null) {
      System.out.println(destinationName);
      predicate = predicate.and(b1.destination.location.in(destinationName));
    }
    if (destinationType != null) {
      System.out.println(destinationType);
      predicate = predicate.and(b1.destination.type.in(destinationType));
    }
    if (numOfDays != null) {
      System.out.println(numOfDays);
      predicate = predicate.and(b1.numOfDay.in(numOfDays));
    }
    
    return predicate;
  }
  
  private Integer[] convertStringArraytoInt(String input)
  {
    String[] temp=input.split(",");
    Integer[] intarray = new Integer[temp.length];
    for(int i = 0;i < temp.length;i++)
    {
       intarray[i] = Integer.parseInt(temp[i]);
    }
    return intarray;
  }
  
  
}
