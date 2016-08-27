package com.practo.wp.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.Destination;
import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;
import com.practo.wp.model.User;
import com.practo.wp.service.DestinationService;
import com.practo.wp.service.TripService;
import com.practo.wp.service.UserService;

@Controller
public class TripListingController {
  private String message = "Hello World";
  @Autowired
  private TripService tripService;
  @Autowired
  private UserService userService;
  @Autowired
  private DestinationService destService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model, Pageable pageable, HttpSession session) {
    model.addAttribute("getAllTrip", tripService.fetchAll(updatePageable(pageable, 10)));
    model.addAttribute("destinations", destService.getall());
    model.addAttribute("destFilters", destService.getFilters());
    model.addAttribute("emailId", session.getAttribute("email"));
    // model.addAttribute("totalPage", page)
    return "index";
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  public String get1(Model model, String tripId, HttpSession session) throws MessagingException {
    // System.out.println();
    model.addAttribute("getAllTrip",
        tripService.signUpForTrip(tripId, (String) session.getAttribute("email")));
    // ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.CREATED);
    // return re;
    return "redirect:/";
  }

  // @RequestMapping("/#")
  // public String home(Model model) {
  // model.addAttribute("time", new Date());
  // model.addAttribute("message", this.message);
  // return "index";
  // }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public void login(Model model, String name, String id, String email, HttpSession session) {
    // String name = request.getParameter("name");
    // if((name!=null))
    // {
    session.setAttribute("name", name);
    session.setAttribute("id", id);
    session.setAttribute("email", email);
    System.out.println(name + "$$$$$$$$$$$$$$$");

    // }
    // model.addAttribute("time", new Date());
    // model.addAttribute("message", this.message);

  }

  @RequestMapping("/signout")
  public String signout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

  @RequestMapping(value = "/postpage", method = RequestMethod.GET)
  public String destination(Model model, HttpSession session) {
    if (session.getAttribute("email") != null) {
      model.addAttribute("emailId", session.getAttribute("email"));
      model.addAttribute("destinations", destService.getall());
      return "post";
    } else {
      return "redirect:/";
    }
  }

  /**
   * @param model
   * @param tripName
   * @param destinationName
   * @param averageCost
   * @param goingDate
   * @param session
   * @return
   */
  @RequestMapping(value = "/post", method = RequestMethod.POST)

  public String post(Model model, String tripName, String destinationName, String averageCost,
      String goingDate, String spaceLeft, String goingPeople, String numOfDay,
      HttpSession session) {
    System.out.println(goingDate);
    System.out.println(tripName);
    System.out.println(destinationName);
    System.out.println(averageCost);
    Trip object = new Trip();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date temp = new Date();
    try {
      temp = dateFormat.parse(goingDate);
      object.setGoingDate(temp);
    } catch (ParseException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    object.setAverageCost(Integer.parseInt(averageCost));
    object.setGoingPeople(Integer.parseInt(goingPeople));
    object.setNumOfDay(Integer.parseInt(numOfDay));
    object.setSpaceLeft(Integer.parseInt(spaceLeft));
    object.setTripName(tripName);

    String emailId = (String) session.getAttribute("email");
    System.out.println(emailId);
    User user1 = userService.getId(emailId);
    System.out.println(user1.getUserId());
    // UserEntity user = user1.convert();
    // object.setUser(user);
    object.setPostedUserId(user1.getUserId());
    Destination dest = destService.getId(destinationName);
    System.out.println(dest.getDestinationId());
    // DestinationEntity destination = dest.convert();
    object.setPostedDestinationId(dest.getDestinationId());
    // object.setDestination(destination);
    Trip dto = new Trip();
    try {
      dto = tripService.create(object);
    } catch (ExceptionMessageThrow e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // System.out.println(obj.getTripName());
    // System.out.println(obj.getAverageCost());
    // System.out.println(obj.getGoingPeople());
    // System.out.println(obj.getNumOfDay());

    // User user1 = userService.getId((String) session.getAttribute("email"));
    // UserEntity user = user1.convert();
    // obj.setUser(user);
    // Trip dto = tripService.create(obj);
    model.addAttribute("postedDetail", dto);
    return "posted";
  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public String search(Model model, String destinationName, String destinationType,
      String numOfDays, String startDate, String endDate, String averageCost, Pageable pageable) {
    TripFilter object = new TripFilter();
    if (destinationName != null && destinationName != "") {
      object.setDestinationName(destinationName);
    }
    if (destinationType != null && destinationType != "") {
      object.setDestinationType(destinationType);
    }
    if (averageCost != null && averageCost != "") {
      object.setAverageCost(averageCost);
    }
    if (startDate != null && startDate != "") {
      object.setStartDate(startDate);
    }
    if (endDate != null && endDate != "") {
      object.setEndDate(endDate);
    }
    if (numOfDays != null && numOfDays != "") {
      object.setNumOfDays(numOfDays);
    }
    System.out.println(object);
    model.addAttribute("getAllTrip",
        tripService.fecthOnFilter(object, updatePageable(pageable, 10)));
    model.addAttribute("destinations", destService.getall());
    model.addAttribute("destFilters", destService.getFilters());
    model.addAttribute("filtername", destinationName);
    model.addAttribute("filtertype", destinationType);
    model.addAttribute("filterdays", numOfDays);
    model.addAttribute("filterstart", startDate);
    model.addAttribute("filterend", endDate);
    model.addAttribute("filtercost", averageCost);
    return "index";
  }

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }
}
