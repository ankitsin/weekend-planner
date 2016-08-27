package com.practo.wp.service;

import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;

import org.springframework.data.domain.Pageable;

import javax.mail.MessagingException;
import javax.transaction.Transactional;



public interface TripService {

  Iterable<Trip> fetchAll(String email, Pageable pageable);

  Trip signUpForTrip(String tripName, String emailId) throws MessagingException;


  Iterable<Trip> fecthOnFilter(String email, TripFilter filter, Pageable pagebale);

  Trip fetchOne(int id);

  Trip create(Trip entity) throws ExceptionMessageThrow;

  String delete(int id) throws ExceptionMessageThrow;

  Trip update(Trip entity) throws ExceptionMessageThrow;

  // String getTotalPage();
}
