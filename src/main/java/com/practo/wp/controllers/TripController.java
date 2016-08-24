package com.practo.wp.controllers;

import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;
import com.practo.wp.service.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller for listing, delete edit trips.
 * 
 * @author ankit
 *
 */
@RestController
@RequestMapping("/trip")
public class TripController {
  @Autowired
  private TripService service;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String method(HttpServletResponse httpServletResponse) {
    return "redirect:" + "http://http://docs.accommodationfinder.apiary.io/";
  }

  /**
   * .
   * 
   * @param pageable ()
   * @return ()
   */
  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public Iterable<Trip> get(Pageable pageable) {
    Iterable<Trip> dto = service.fetchAll(updatePageable(pageable, 50));
    return dto;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Trip get2(@PathVariable("id") int id) {
    Trip dto = service.fetchOne(id);
    return dto;
  }

  /**
   * .
   * 
   * @param filter ()
   * @param pageable ()
   * @return ()
   */
  @RequestMapping(value = "/filter", method = RequestMethod.GET)
  public Iterable<Trip> get2(TripFilter filter, Pageable pageable) {
    System.out.println(filter);
    Iterable<Trip> dto = service.fecthOnFilter(filter, pageable);
    return dto;
  }


  /**
   * This is function for getting trip information for specific id.
   * 
   * @param id ()
   * @return ()
   * 
   */
  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  public ResponseEntity<Trip> get1(@RequestBody String tripIdemailId) throws MessagingException {
    System.out.println(tripIdemailId);
    Trip dto = service.signUpForTrip(tripIdemailId);
    ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.CREATED);
    return re;
  }

  /**
   * .
   * 
   * @param obj ()
   * @return ()
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Trip> create(@RequestBody Trip obj) throws ExceptionMessageThrow {
    Trip dto = service.create(obj);
    ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.CREATED);
    return re;
  }

  /**
   * .
   * 
   * @param obj ()
   * @return ()
   */
  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<Trip> update(@RequestBody Trip obj) throws ExceptionMessageThrow {
    Trip dto = service.update(obj);
    ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.OK);
    return re;
  }

  /**
   * .
   * 
   * @param id ()
   * @param response ()
   * @return ()
   */
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response)
      throws ExceptionMessageThrow {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }
}
