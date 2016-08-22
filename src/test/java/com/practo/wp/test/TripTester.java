package com.practo.wp.test;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.data.dao.TripDao;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.model.Trip;
import com.practo.wp.run.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class TripTester {
  // Required to Generate JSON content from Java objects
  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  // Required to delete the data added for tests.
  // Directly invoke the APIs interacting with the DB
  @Autowired
  private TripDao TripDao;

  // Test RestTemplate to invoke the APIs.
  private RestTemplate restTemplate = new TestRestTemplate();
   @Test
   public void testCreateTripApi() throws JsonProcessingException{

   Map<String, Object> requestBody = new HashMap<String, Object>();
   requestBody.put("averageCost", 10000);
   requestBody.put("goingDate", "2016-09-12");
   requestBody.put("goingPeople",4);
   requestBody.put("numOfDay", 4);
   requestBody.put("spaceLeft", 4);
   requestBody.put("tripName", "Once Again Trip to Nandi Hills");
   requestBody.put("postedDestinationId", 1);
   requestBody.put("postedUserId", 1);
   HttpHeaders requestHeaders = new HttpHeaders();
   requestHeaders.setContentType(MediaType.APPLICATION_JSON);
  
   //Creating http entity object with request body and headers
   HttpEntity<String> httpEntity =
   new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);
  
   //Invoking the API
   Map<String, Object> apiResponse =
   restTemplate.postForObject("http://localhost:8080/trip", httpEntity, Map.class,
   Collections.EMPTY_MAP);
  
   assertNotNull(apiResponse);
  
   //Asserting the response of the API.
   String message = apiResponse.get("message").toString();
   System.out.println(message);
   assertEquals("Trip created successfully", message);
  
  
   }
  @Test
  public void testGetTripDetailsApi() {

    Trip apiResponse = restTemplate.getForObject("http://localhost:8080/trip/10", Trip.class);

    // Verify that the data from the API and data saved in the DB are same
    assertNotNull(apiResponse);
    System.out.println(apiResponse + "@@@@@@@@@");
    assertEquals("Once Again Trip to Nandi Hills", apiResponse.getTripName());
  }
  @Test
  public void testDeleteTripApi(){

    restTemplate.delete("http://localhost:8080/trip/delete/9", Collections.EMPTY_MAP);
    
    TripEntity bookFromDb = TripDao.findByTripIdAndIsDeleted(9, (byte)0);
    //and assert that there is no data found
    assertNull(bookFromDb);
  }


}
