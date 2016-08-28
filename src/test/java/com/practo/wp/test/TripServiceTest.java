package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.Trip;
import com.practo.wp.run.Application;
import com.practo.wp.service.TripService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TripServiceTest {

  @Autowired
  private TripService service;


  //
  @Test
  public void testTripCreateApi() throws ExceptionMessageThrow {

    Trip model = new Trip();
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
  public void testTripGetDetailsApi() {
    Trip apiResponse = service.fetchOne(1);
    assertNotNull(apiResponse);
    assertEquals("Trip to Muthyala Maduvu", apiResponse.getTripName());
    assertEquals(5000, apiResponse.getAverageCost());
    // Trip newApiResponse = service.fetchOne(2);
    // assertNotNull(newApiResponse);
    // assertEquals("New Once Again Trip to Nandi Hills", newApiResponse.getTripName());
    // assertEquals(10000, newApiResponse.getAverageCost());
  }

  @Test
  public void testTripUpdateDetailsApi() throws ExceptionMessageThrow {
    Trip apiResponse = new Trip();
    apiResponse = service.fetchOne(1);
    apiResponse.setAverageCost(6000);
    // Trip updatedApiResponse = new Trip();
    // apiResponse = service.update(apiResponse);
    assertNotNull(apiResponse);
    assertEquals("Trip to Muthyala Maduvu", apiResponse.getTripName());
    assertEquals(6000, apiResponse.getAverageCost());
  }

  @Test
  public void testTripZDeleteApi() throws ExceptionMessageThrow {
    String apiResponse = service.delete(1);
    assertEquals("Operation done successfully", apiResponse);
    // assertNull(bookFromDb);
  }
}
