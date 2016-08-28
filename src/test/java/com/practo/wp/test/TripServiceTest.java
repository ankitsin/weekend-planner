package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;
import com.practo.wp.run.Application;
import com.practo.wp.service.TripService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TripServiceTest {

  @Autowired
  private TripService service;


  //
  @Test
  public void testTripCreate() throws ExceptionMessageThrow {

    Trip model = new Trip();
    // model.setTripId(2);
    model.setAverageCost(10000);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date temp = new Date();
    try {
      temp = dateFormat.parse("2016-08-23");
      model.setGoingDate(temp);
    } catch (ParseException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    model.setGoingPeople(4);
    model.setNumOfDay(4);
    model.setSpaceLeft(4);
    model.setTripName("New Once Again Trip to Nandi Hills");
    model.setPostedUserId(1);
    model.setPostedDestinationId(1);
    Trip apiResponse = service.create(model);
    assertNotNull(apiResponse);
  }

  @Test
  public void testTripGetDetails() {
    Trip apiResponse = service.fetchOne(1);
    assertNotNull(apiResponse);
    assertEquals("Trip to Muthyala Maduvu", apiResponse.getTripName());
    assertEquals(5000, apiResponse.getAverageCost());
    // Trip newApiResponse = service.fetchOne(2);
    // assertNotNull(newApiResponse);
    // assertEquals("New Once Again Trip to Nandi Hills", newApiResponse.getTripName());
    // assertEquals(10000, newApiResponse.getAverageCost());
  }

  // @Test
  // public void testTripAUpdateDetailsApi() throws ExceptionMessageThrow {
  // Trip model1 = new Trip();
  // model1.setAverageCost(1000);
  // model1.setTripId(1);
  // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  // Date temp = new Date();
  // try {
  // temp = dateFormat.parse("2016-08-23");
  // model1.setGoingDate(temp);
  // } catch (ParseException e1) {
  // // TODO Auto-generated catch block
  // e1.printStackTrace();
  // }
  // model1.setGoingPeople(4);
  // model1.setNumOfDay(4);
  // model1.setSpaceLeft(4);
  // model1.setTripName("New Once Again Trip to Nandi Hills");
  // model1.setPostedUserId(1);
  // model1.setPostedDestinationId(1);
  // service.update(model1);
  // // Trip newApiResponse = service.fetchOne(2);
  // // assertNotNull(newApiResponse);
  // // assertEquals("Trip to Muthyala Maduvu", newApiResponse.getTripName());
  // // assertEquals(1000, newApiResponse.getAverageCost());
  // }

  @Test
  public void testSignUpTrip() {
    Trip apiResponse = null;
    try {
      apiResponse = service.signUpForTrip("2", "vikas.bhoria@practo.com");
    } catch (MessagingException exc) {
      // TODO Auto-generated catch block
      exc.printStackTrace();
    }
    assertNotNull(apiResponse);
  }

  @Test
  public void testFetchAll() {

    Iterable<Trip> apiResponse = service.fetchAll("vikas.bhoria@practo.com", new Pageable() {


      @Override
      public int getPageSize() {
        // TODO Auto-generated method stub
        return 0;
      }

      @Override
      public int getPageNumber() {
        // TODO Auto-generated method stub
        return 0;
      }

      @Override
      public int getOffset() {
        // TODO Auto-generated method stub
        return 0;
      }

      @Override
      public Pageable first() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Sort getSort() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public boolean hasPrevious() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public Pageable next() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Pageable previousOrFirst() {
        // TODO Auto-generated method stub
        return null;
      }

    });
    assertNotNull(apiResponse);
  }

  @Test
  public void testTripZDeleteApi() throws ExceptionMessageThrow {
    String apiResponse = service.delete(1);
    assertEquals("Operation done successfully", apiResponse);
    // assertNull(bookFromDb);
  }


  @Test
  public void testTripFilter() throws ExceptionMessageThrow {
    TripFilter filter = new TripFilter();
    filter.setAverageCost("1000");
    filter.setEndDate("2016-08-29");
    filter.setStartDate("2016-09-31");
    filter.setSpaceLeft("2");
    filter.setDestinationType("Waterfall");
    filter.setNumOfDays("2");
    Iterable<Trip> apiResponse =
        service.fecthOnFilter("vikas.bhoria@practo.com", filter, new Pageable() {

          @Override
          public Pageable previousOrFirst() {
            return null;
          }

          @Override
          public Pageable next() {
            return null;
          }

          @Override
          public boolean hasPrevious() {
            return false;
          }

          @Override
          public Sort getSort() {
            return null;
          }

          @Override
          public int getPageSize() {
            return 0;
          }

          @Override
          public int getPageNumber() {
            return 0;
          }

          @Override
          public int getOffset() {
            return 0;
          }

          @Override
          public Pageable first() {
            return null;
          }
        });
    assertNotNull(apiResponse);
    // assertNull(bookFromDb);
  }
}
