package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.model.User;
import com.practo.wp.run.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class UnitTester {
  // Required to Generate JSON content from Java objects
  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  // Required to delete the data added for tests.
  // Directly invoke the APIs interacting with the DB

  // Test RestTemplate to invoke the APIs.
  private RestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void testGetUserDetailsApi() {

    User apiResponse = restTemplate.getForObject("http://localhost:8080/user/2", User.class);
    assertNotNull(apiResponse);
    System.out.println(apiResponse + "@@@@@@@@@");
    assertEquals("ankit.singh@practo.com", apiResponse.getEmailId());
    assertEquals("Ankit Singh", apiResponse.getName());
    assertEquals("9125551187", apiResponse.getMobile());

  }
}
