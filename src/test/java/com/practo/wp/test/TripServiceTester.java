package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.Trip;
import com.practo.wp.run.Application;
import com.practo.wp.service.TripService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TripServiceTester {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  // @Autowired
  // private TripDao tripDao;
  @Autowired
  private TripService service;


  //
  @Test
  public void testTripCreateApi() throws JsonProcessingException, ExceptionMessageThrow {

    Trip entity = new Trip();
    entity.setAverageCost(10000);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date temp = new Date();
    try {
      temp = dateFormat.parse("2016-08-23");
      entity.setGoingDate(temp);
    } catch (ParseException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    entity.setGoingPeople(4);
    entity.setNumOfDay(4);
    entity.setSpaceLeft(4);
    entity.setTripName("New Once Again Trip to Nandi Hills");
    entity.setPostedUserId(1);
    entity.setPostedDestinationId(1);
    Trip apiResponse = service.create(entity);
    assertNotNull(apiResponse);
  }

  @Test
  public void testTripGetDetailsApi() {
    // Trip apiResponse = restTemplate.getForObject("http://localhost:8080/trip/10", Trip.class);
    Trip apiResponse = service.fetchOne(1);
    assertNotNull(apiResponse);
    assertEquals("Trip to Muthyala Maduvu", apiResponse.getTripName());
    assertEquals("5000", apiResponse.getAverageCost());
    Trip newApiResponse = service.fetchOne(2);
    assertNotNull(newApiResponse);
    assertEquals("New Once Again Trip to Nandi Hills", newApiResponse.getTripName());
    assertEquals("10000", newApiResponse.getAverageCost());
  }

  @Test
  public void testTripUpdateDetailsApi() throws ExceptionMessageThrow {
    // Trip apiResponse = restTemplate.getForObject("http://localhost:8080/trip/10", Trip.class);
    Trip apiResponse = service.fetchOne(1);
    apiResponse.setAverageCost(60000);
    Trip updatedApiResponse = service.update(apiResponse);
    assertNotNull(updatedApiResponse);
    assertEquals("Trip to Muthyala Maduvu", updatedApiResponse.getTripName());
    assertEquals("6000", updatedApiResponse.getAverageCost());
  }

  @Test
  public void testTripZDeleteApi() throws ExceptionMessageThrow {
    String apiResponse = service.delete(1);
    assertEquals("Operation done successfully", apiResponse);
    // assertNull(bookFromDb);
  }


}
