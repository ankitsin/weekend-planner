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
import com.practo.wp.model.Destination;
import com.practo.wp.model.Trip;
import com.practo.wp.model.User;
import com.practo.wp.run.Application;

import ch.qos.logback.classic.boolex.IEvaluator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class DestinationTester {
  // Required to Generate JSON content from Java objects
  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  // Required to delete the data added for tests.
  // Directly invoke the APIs interacting with the DB
  
//Test RestTemplate to invoke the APIs.
  private RestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void testGetUserDetailsApi(){
    //Create a new book using the BookRepository API
//    Book book = new Book("Book1", "ÏSBN1", "Author1", 200);
//    bookRepository.save(book);
//    
//    String bookId = book.getId();
    
    //Now make a call to the API to get details of the book
    Destination apiResponse = restTemplate.getForObject("http://localhost:8080/destination/1", Destination.class);
    
    //Verify that the data from the API and data saved in the DB are same
    assertNotNull(apiResponse);
    System.out.println(apiResponse+"@@@@@@@@@");
    assertEquals("Nandi-Hills", apiResponse.getLocation());
    assertEquals("Hill Station", apiResponse.getType());
    assertEquals(71, apiResponse.getDistance());
//    assertEquals(1, apiResponse.getSpaceLeft());
//    assertEquals(3, apiResponse.getNumOfDay());
//    assertEquals(6000, apiResponse.getAverageCost());
//    
//    //Delete the Test data created
//    bookRepository.delete(bookId);
  }
}
