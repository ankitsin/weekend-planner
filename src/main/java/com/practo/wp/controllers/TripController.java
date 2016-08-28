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
 * Controller for getting listing of all the trips, listig based on user, deletion and editing of
 * the trip by user who has posted it.
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
   * Get trip based on email Id.
   * 
   * @param emailId ()
   * @param pageable {@link Pageable}
   * @return ()
   */
  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public Iterable<Trip> get(String emailId, Pageable pageable) {
    Iterable<Trip> dto = service.fetchAll(emailId, updatePageable(pageable, 10));
    return dto;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Trip getOnId(@PathVariable("id") int id) {
    Trip dto = service.fetchOne(id);
    return dto;
  }


  /**
   * Get the listing of trips based on filters.
   * 
   * @param emailId email id of user
   * @param filter {@link TripFilter}
   * @param pageable {@link Pageable}
   * @return ()
   */
  @RequestMapping(value = "/filter", method = RequestMethod.GET)
  public Iterable<Trip> getOnFilters(String emailId, TripFilter filter, Pageable pageable) {
    System.out.println(filter);
    Iterable<Trip> dto = service.fecthOnFilter(emailId, filter, pageable);
    return dto;
  }


  /**
   * This is function for signing up for the trip. The finction calls {@link TripService} for
   * getting posted user's emailID and sending mail.
   * 
   * @param tripId for getting the user mail Id
   * @param emailId email id of user
   * @return {@link ResponseEntity}
   * @throws MessagingException ()
   */
  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  public ResponseEntity<Trip> get1(@RequestBody String tripId, String emailId)
      throws MessagingException {
    // System.out.println(tripIdemailId);
    Trip dto = service.signUpForTrip(tripId, emailId);
    ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.CREATED);
    return re;
  }

  /**
   * Create a trip object.
   * 
   * @param obj {@link Trip}
   * @return {@link ResponseEntity}
   * @throws ExceptionMessageThrow message
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Trip> create(@RequestBody Trip obj) throws ExceptionMessageThrow {
    Trip dto = service.create(obj);
    ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.CREATED);
    return re;
  }

  /**
   * For upadting the trip details using put method.
   * 
   * @param obj id {@link Trip} model
   * @return {@link ResponseEntity}
   * @throws ExceptionMessageThrow message
   */
  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<Trip> update(@RequestBody Trip obj) throws ExceptionMessageThrow {
    Trip dto = service.update(obj);
    ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.OK);
    return re;
  }

  /**
   * Deletes(soft) the trip detail by making isdelete column value true and changing modified date
   * to current time.
   * 
   * @param id of the Trip
   * @param response ()
   * @return {@link ResponseEntity}
   * @throws ExceptionMessageThrow message
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
