package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.model.Trip;
import com.practo.wp.run.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TripTester {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private TestRestTemplate restTemplate;
  // @Autowired
  // private TripDao tripDao;



  @Test
  public void testCreateTripApi() throws JsonProcessingException {

    Map<String, Object> requestBody = new HashMap<String, Object>();
    requestBody.put("averageCost", 10000);
    requestBody.put("goingDate", "2016-09-12");
    requestBody.put("goingPeople", 4);
    requestBody.put("numOfDay", 4);
    requestBody.put("spaceLeft", 4);
    requestBody.put("tripName", "Once Again Trip to Nandi Hills");
    requestBody.put("postedDestinationId", 1);
    requestBody.put("postedUserId", 1);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> httpEntity =
        new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

    @SuppressWarnings("unchecked")
    Map<String, Object> apiResponse = restTemplate.postForObject("http://localhost:8080/trip",
        httpEntity, Map.class, Collections.EMPTY_MAP);
    assertNotNull(apiResponse);
    @SuppressWarnings("unused")
    String message = apiResponse.get("message").toString();
    assertNotNull(apiResponse);
  }

  @Test
  public void testGetTripDetailsApi() {
    Trip apiResponse = restTemplate.getForObject("http://localhost:8080/trip/10", Trip.class);
    assertNotNull(apiResponse);
    assertEquals("Once Again Trip to Nandi Hills", apiResponse.getTripName());
  }

  // @SuppressWarnings("unchecked")
  // @Test
  // public void testDeleteTripApi() {
  // restTemplate.delete("http://localhost:8080/trip/delete/9", Collections.EMPTY_MAP);
  // TripEntity bookFromDb = tripDao.findByTripIdAndIsDeleted(9, (byte) 0);
  // assertNull(bookFromDb);
  // }


}
