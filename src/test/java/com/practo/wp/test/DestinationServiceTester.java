package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.model.Destination;
import com.practo.wp.run.Application;
import com.practo.wp.service.DestinationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DestinationServiceTester {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Autowired
  private DestinationService service;

  @Test
  public void testGetUserDetailsApi() {
    Destination apiResponse = service.getById(1);
    assertNotNull(apiResponse);
    System.out.println(apiResponse + "@@@@@@@@@");
    assertEquals("Nandi-Hills", apiResponse.getLocation());
    assertEquals("Hill Station", apiResponse.getType());
    assertEquals(71, apiResponse.getDistance());
  }
}
