
package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.practo.wp.model.User;
import com.practo.wp.run.Application;
import com.practo.wp.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UnitServiceTest {
  @Autowired
  private UserService service;

  @Test
  public void testGetUserDetailsApi() throws MessagingException {
    User apiResponse = service.get(1);
    System.out.println(apiResponse.getEmailId());
    assertNotNull(apiResponse);
    assertEquals("vikas.bhoria@practo.com", apiResponse.getEmailId());
    assertEquals("Vikas Bhoria", apiResponse.getName());
    assertEquals("8960032462", apiResponse.getMobile());
  }
}
