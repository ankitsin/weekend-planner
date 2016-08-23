package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.model.Destination;
import com.practo.wp.run.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DestinationTester {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private TestRestTemplate restTemplate;

  @Test
  public void testGetUserDetailsApi() {
    Destination apiResponse =
        restTemplate.getForObject("http://localhost:8080/destination/1", Destination.class);
    assertNotNull(apiResponse);
    System.out.println(apiResponse + "@@@@@@@@@");
    assertEquals("Nandi-Hills", apiResponse.getLocation());
    assertEquals("Hill Station", apiResponse.getType());
    assertEquals(71, apiResponse.getDistance());
  }
}
