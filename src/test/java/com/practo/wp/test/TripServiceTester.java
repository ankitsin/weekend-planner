package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.model.Trip;
import com.practo.wp.run.Application;
import com.practo.wp.service.TripService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TripServiceTester {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  // @Autowired
  // private TripDao tripDao;
  @Autowired
  private TripService service;



  @Test
  public void testCreateTripApi() throws JsonProcessingException {

    Calendar cal = Calendar.getInstance();
    cal.clear(Calendar.HOUR_OF_DAY);
    cal.clear(Calendar.AM_PM);
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MILLISECOND);
    Date today = cal.getTime();
    System.out.println(cal);
    Trip entity = new Trip();
    entity.setAverageCost(10000);
    entity.setGoingDate(today);
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
  public void testGetTripDetailsApi() {
    // Trip apiResponse = restTemplate.getForObject("http://localhost:8080/trip/10", Trip.class);
    Trip apiResponse = service.fetchOne(10);
    assertNotNull(apiResponse);
    assertEquals("Once Again Trip to Nandi Hills", apiResponse.getTripName());
  }

  @Test
  public void testDeleteTripApi() {
    service.delete(10);
    // assertNull(bookFromDb);
  }


}
