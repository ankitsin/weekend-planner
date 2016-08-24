
package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.wp.model.User;
import com.practo.wp.run.Application;
import com.practo.wp.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UnitServiceTester {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  @Autowired
  private UserService service;
  // private EmbeddedDatabase db;
  // UserDao userDao;
  //
  // /**
  // * .
  // */
  // @Before
  // public void setUp() {
  // // db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
  // db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
  // .addScript("db/sql/create-db.sql").build();
  // }

  @Test
  public void testGetUserDetailsApi() {

    // User apiResponse = restTemplate.getForObject("http://localhost:8080/user/2", User.class);
    // NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
    // UserDao userDao = new UserDao();
    // userDao.setNamedParameterJdbcTemplate(template);
    User apiResponse = service.get(2);
    System.out.println(apiResponse.getEmailId());
    assertNotNull(apiResponse);
    assertEquals("ankit.singh@practo.com", apiResponse.getEmailId());
    assertEquals("Ankit Singh", apiResponse.getName());
    assertEquals("9125551187", apiResponse.getMobile());
  }

  // @After
  // public void tearDown() {
  // db.shutdown();
  // }

}
