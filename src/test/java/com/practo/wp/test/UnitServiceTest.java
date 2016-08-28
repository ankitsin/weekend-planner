
package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.mail.MessagingException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.wp.model.User;
import com.practo.wp.run.Application;
import com.practo.wp.service.UserService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UnitServiceTest {
  @Autowired
  private UserService service;

  @Test
  public void testCreateUser() throws MessagingException {
    User user = new User();
    user.setEmailId("ankit.singh.2016@iitkalumni.org");
    user.setMobile("8601461142");
    user.setName("Ankit Singh");
    user.setUserId(3);
    User apiResponse = service.createUser(user);
    // System.out.println(apiResponse.getEmailId());
    assertNull(apiResponse);
    // assertEquals("vikas.bhoria@practo.com", apiResponse.getEmailId());
    // assertEquals("Vikas Bhoria", apiResponse.getName());
    // assertEquals("8960032462", apiResponse.getMobile());
  }

  @Test
  public void testGetUserDetails() throws MessagingException {
    User apiResponse = service.get(3);
    System.out.println(apiResponse.getEmailId());
    assertNotNull(apiResponse);
    assertEquals("ankit.singh.2016@iitkalumni.org", apiResponse.getEmailId());
    assertEquals("Ankit Singh", apiResponse.getName());
    assertEquals("8601461142", apiResponse.getMobile());
  }

  @Test
  public void testGetUserDetailsByEmail() throws MessagingException {
    User apiResponse = service.getByEmailId("vikas.bhoria@practo.com");
    System.out.println(apiResponse.getEmailId());
    assertNotNull(apiResponse);
    assertEquals("vikas.bhoria@practo.com", apiResponse.getEmailId());
    assertEquals("Vikas Bhoria", apiResponse.getName());
    assertEquals("8960032462", apiResponse.getMobile());
  }

  @Test
  public void testUpdateUserDetails() throws MessagingException {
    User user = new User();
    user.setEmailId("ankit.singh@iitkalumni.org");
    user.setMobile("8601461142");
    user.setName("Ankit Singh");
    user.setUserId(2);
    User apiResponse = service.upadteUser(user);
    User newApiResponse = service.getByEmailId("ankit.singh@iitkalumni.org");
    System.out.println(newApiResponse.getEmailId());
    assertNotNull(newApiResponse);
    assertEquals("ankit.singh@iitkalumni.org", newApiResponse.getEmailId());
    assertEquals("Ankit Singh", newApiResponse.getName());
    assertEquals("8601461142", newApiResponse.getMobile());
  }

}
