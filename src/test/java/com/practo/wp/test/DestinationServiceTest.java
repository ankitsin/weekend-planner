package com.practo.wp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.practo.wp.model.Destination;
import com.practo.wp.run.Application;
import com.practo.wp.service.DestinationService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DestinationServiceTest {

  @Autowired
  private DestinationService service;

  @Test
  public void testCreateDestination() {
    Destination destination = new Destination();
    destination.setDestinationId(2);
    destination.setDistance(99);
    destination.setLocation("Nandi");
    destination.setType("Hill");
    service.createDestination(destination);
    Destination apiResponse = service.getByName("Nandi");;
    assertNotNull(apiResponse);
    assertEquals("Nandi", apiResponse.getLocation());
    assertEquals("Hill", apiResponse.getType());
    assertEquals(99, apiResponse.getDistance());
  }

  @Test
  public void testUpdateDestination() {
    Destination destination = new Destination();
    destination.setDestinationId(2);
    destination.setDistance(99);
    destination.setLocation("Nandi-Hills");
    destination.setType("Hill");
    service.updateDestination(destination);
    Destination apiResponse = service.getId("Nandi-Hills");
    assertNotNull(apiResponse);
    assertEquals("Nandi-Hills", apiResponse.getLocation());
    assertEquals("Hill", apiResponse.getType());
    assertEquals(99, apiResponse.getDistance());
  }

  @Test
  public void testGetDestinationDetails() {
    Destination apiResponse = service.getById(1);
    assertNotNull(apiResponse);
    assertEquals("Muthyala Maduvu", apiResponse.getLocation());
    assertEquals("Waterfall", apiResponse.getType());
    assertEquals(43, apiResponse.getDistance());
  }

  @Test
  public void testGetFilters() {
    Iterable<String> apiResponse = service.getFilters();
    assertNotNull(apiResponse);
  }

  /**
   * Testing on getting all the destinations.
   */
  @Test
  public void testGetAllDestinationDetails() {
    Iterable<Destination> apiResponse = service.getall();
    assertNotNull(apiResponse);
  }

}
