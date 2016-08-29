package com.practo.wp.controllers;

import com.practo.wp.model.Destination;
import com.practo.wp.service.DestinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * Controller for getting details of the destinations available in the databse.
 * 
 * @author ankit
 *
 */
@RestController
@RequestMapping("/destination")
public class DestinationController {

  @Autowired
  private DestinationService destinationService;

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public Iterable<Destination> get() {
    Iterable<Destination> dto = destinationService.getall();
    return dto;
  }

  /**
   * Get the destination {@link Destination} details with the given id.
   * 
   * @param id {@link Integer} id passed to get details
   * @return ()
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Destination get(@PathVariable("id") Integer id) {
    System.out.println(id);
    Destination dto = destinationService.getById(id);
    return dto;
  }
}
