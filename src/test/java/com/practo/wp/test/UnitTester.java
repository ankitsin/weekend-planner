
package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.model.User;
import com.practo.wp.run.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UnitTester {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private TestRestTemplate restTemplate;

  @Test
  public void testGetUserDetailsApi() {

    User apiResponse = restTemplate.getForObject("http://localhost:8080/user/2", User.class);
    assertNotNull(apiResponse);
    assertEquals("ankit.singh@practo.com", apiResponse.getEmailId());
    assertEquals("Ankit Singh", apiResponse.getName());
    assertEquals("9125551187", apiResponse.getMobile());

  }
}
