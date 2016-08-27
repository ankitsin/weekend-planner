package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.model.Destination;
import com.practo.wp.run.Application;
import com.practo.wp.service.DestinationService;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DestinationServiceTester {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Autowired
  private DestinationService service;

  @Test
  public void testGetDestinationDetailsApi() {
    Destination apiResponse = service.getById(1);
    assertNotNull(apiResponse);
    System.out.println(apiResponse + "@@@@@@@@@");
    assertEquals("Muthyala Maduvu", apiResponse.getLocation());
    assertEquals("Waterfall", apiResponse.getType());
    assertEquals(43, apiResponse.getDistance());
  }
  
}
