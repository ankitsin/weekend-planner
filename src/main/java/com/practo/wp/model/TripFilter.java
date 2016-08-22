package com.practo.wp.model;




import com.practo.wp.data.entity.QTripEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class TripFilter {
  private String spaceLeft=null;
  private String destinationName=null;
  private String destinationType=null;
  private String averageCost=null;
  public String getAverageCost() {
    return averageCost;
  }

  public void setAverageCost(String averageCost) {
    this.averageCost = averageCost;
  }

  public String getNumOfDays() {
    return numOfDays;
  }

  public void setNumOfDays(String numOfDays) {
    this.numOfDays = numOfDays;
  }

  private String numOfDays=null;
  public String getDestinationName() {
    return destinationName;
  }

  public void setDestinationName(String destinationName) {
    this.destinationName = destinationName;
  }

  public String getDestinationType() {
    return destinationType;
  }

  public void setDestinationType(String destinationType) {
    this.destinationType = destinationType;
  }


  public String getSpaceLeft() {
    return spaceLeft;
  }

  public void setSpaceLeft(String spaceLeft) {
    this.spaceLeft = spaceLeft;
  }

  public Predicate toPredicate() {

    QTripEntity b1 = QTripEntity.tripEntity;
    BooleanExpression predicate = b1.isDeleted.eq((byte)0);
//    BooleanExpression predicate =null;
    System.out.println(spaceLeft);
    if (spaceLeft != null) {
      System.out.println(spaceLeft);
      predicate = predicate.and(b1.spaceLeft.eq(Integer.parseInt(spaceLeft)));
    }
    if (destinationName != null) {
      System.out.println(destinationName);
      predicate = predicate.and(b1.destination.location.eq(destinationName));
    }
    if (destinationType != null) {
      System.out.println(destinationType);
      predicate = predicate.and(b1.destination.type.eq(destinationType));
    }
    if (numOfDays != null) {
      System.out.println(numOfDays);
      predicate = predicate.and(b1.numOfDay.eq(Integer.parseInt(numOfDays)));
    }
    
    return predicate;
  }
}
