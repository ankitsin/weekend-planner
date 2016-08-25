package com.practo.wp.controllers;

import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;
import com.practo.wp.service.DestinationService;
import com.practo.wp.service.TripService;

@Controller
public class TripListingController {
  private String message = "Hello World";
  @Autowired
  private TripService tripService;
  @Autowired
  private DestinationService destService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model, Pageable pageable) {
    model.addAttribute("getAllTrip", tripService.fetchAll(updatePageable(pageable, 10)));
    model.addAttribute("destinations", destService.getall());
    model.addAttribute("destFilters", destService.getFilters());
    return "index";
  }

  // @RequestMapping(value = "/signup", method = RequestMethod.POST)
  // public ResponseEntity<Trip> get1(@RequestBody String tripIdemailId) throws MessagingException {
  // System.out.println(tripIdemailId);
  // model.addAttribute("getAllTrip",Trip dto = tripService.signUpForTrip(tripIdemailId))
  //// ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.CREATED);
  //// return re;
  // }
  @RequestMapping("/#")
  public String home(Model model) {
    model.addAttribute("time", new Date());
    model.addAttribute("message", this.message);
    return "index";
  }

  @RequestMapping("/login")
  public String login(Model model) {
    model.addAttribute("time", new Date());
    model.addAttribute("message", this.message);
    return "login";
  }

  @RequestMapping("/destination")
  public String destination(Model model) {
    model.addAttribute("time", new Date());
    model.addAttribute("message", this.message);
    return "destination";
  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public String search(Model model, TripFilter object, Pageable pageable) {
    System.out.println(object);
    model.addAttribute("getAllTrip",
        tripService.fecthOnFilter(object, updatePageable(pageable, 10)));
    model.addAttribute("destinations", destService.getall());
    model.addAttribute("destFilters", destService.getFilters());
    return "index";
  }

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }
}
