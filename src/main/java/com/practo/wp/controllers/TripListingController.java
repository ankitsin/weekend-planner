package com.practo.wp.controllers;

import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.Destination;
import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;
import com.practo.wp.model.User;
import com.practo.wp.service.DestinationService;
import com.practo.wp.service.TripService;
import com.practo.wp.service.UserService;
import com.practo.wp.utility.UpdatePageableUntility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

/**
 * Controller for listing, posting of the trips.
 * 
 * @author ankit
 *
 */
@Controller
public class TripListingController {
  @Autowired
  private TripService tripService;
  @Autowired
  private UserService userService;
  @Autowired
  private DestinationService destService;

  /**
   * Get the listing sorted on the date of trip happening.
   * 
   * @param model {@link Model}
   * @param pageable {@link Pageable}
   * @param session {@link HttpSession}
   * @return listing details, user details if logged in, filter details
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model, Pageable pageable, HttpSession session) {
    String email = (String) session.getAttribute("email");
    model.addAttribute("getAllTrip",
        tripService.fetchAll(email, UpdatePageableUntility.updatePageable(pageable, 10)));
    model.addAttribute("destinations", destService.getall());
    model.addAttribute("destFilters", destService.getFilters());
    model.addAttribute("emailId", session.getAttribute("email"));
    model.addAttribute("name", session.getAttribute("name"));
    model.addAttribute("pageno", pageable.getPageNumber());
    return "index";
  }

  /**
   * Function for making database changes when someone register for trip, sending mail to
   * registering user and posting user.
   * 
   * @param model {@link Model}
   * @param tripId get trip id from frontend in which user signups
   * @param session {@link HttpSession}
   * @return redirect url to homepage
   * @throws MessagingException ()
   */
  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  public String signUpTrip(Model model, String tripId, HttpSession session)
      throws MessagingException {
    // System.out.println();
    model.addAttribute("signedUp",
        tripService.signUpForTrip(tripId, (String) session.getAttribute("email")));
    // ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.CREATED);
    // return re;
    return "email";
  }


  /**
   * This funtion is for making httpsession for a user, creating user data when he registers for the
   * first time.
   * 
   * @param model {@link Model}
   * @param name name of user
   * @param id currentlty id send by google,later for token id for backend valiadtion check
   * @param emailId email id of signing up user
   * @param session {@link HttpSession}
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public void login(Model model, String name, String id, String emailId, HttpSession session) {

    session.setAttribute("name", name);
    session.setAttribute("id", id);
    session.setAttribute("email", emailId);
    System.out.println(name + "$$$$$$$$$$$$$$$");
    User user = new User();
    user = userService.getId(emailId);
    if (user.getEmailId() == null) {
      user.setEmailId(emailId);
      user.setName(name);
      user.setMobile(null);
      @SuppressWarnings("unused")
      User temp = userService.createUser(user);
    }
  }

  /**
   * Invalidate the seesion of user.
   * 
   * @param session {@link HttpSession}
   * @return redirects to the home page
   */
  @RequestMapping("/signout")
  public String signout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

  /**
   * This function get the name of all destination on ppstpage so that user can select from dropdown
   * menu.
   * 
   * @param model {@link Model}
   * @param session {@link HttpSession}
   * @return emailId of logged in user and destination details
   */
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
   * Function called when a user clicks on post. Creates the post in database and show the trip
   * posted details on another page
   * 
   * @param model {@link Model}
   * @param tripName name of the trip given by user
   * @param destinationName destination name
   * @param averageCost avergae cost of trip
   * @param goingDate date on which trip is happening
   * @param numOfDay
   * @param session {@link HttpSession}
   * @return trip information posted by user
   */
  /**
   * Function called when a user clicks on post. Creates the post in database and show the trip
   * posted details on another page
   * 
   * @param model {@link Model}
   * @param tripName name of the trip given by user
   * @param destinationName destination name
   * @param averageCost avergae cost of trip
   * @param goingDate date on which trip is happening
   * @param spaceLeft space left
   * @param goingPeople number of people going
   * @param numOfDay trip for how many days
   * @param session {@link HttpSession}
   * @return {@link String}
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
    object.setPostedUserId(user1.getUserId());
    Destination dest = destService.getId(destinationName);
    System.out.println(dest.getDestinationId());
    object.setPostedDestinationId(dest.getDestinationId());
    Trip dto = new Trip();
    try {
      dto = tripService.create(object);
    } catch (ExceptionMessageThrow exc) {
      exc.printStackTrace();
    }
    model.addAttribute("postedDetail", dto);
    return "posted";
  }

  /**
   * This function act as search on home page as well as get trips based on filters.
   * 
   * @param model {@link Model}
   * @param destinationName destination name when user search for trip
   * @param destinationType destination type
   * @param numOfDays how many days of trip
   * @param startDate search between days(start)
   * @param endDate search between days(end)
   * @param averageCost average cost per user
   * @param pageable for getting 10 number of results on evrypage
   * @param session session variable for session maintainace
   * @return index the homepage/listing page of portal
   */
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public String search(Model model, String destinationName, String destinationType,
      String numOfDays, String startDate, String endDate, String averageCost, Pageable pageable,
      HttpSession session) {
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
    String email = (String) session.getAttribute("email");
    model.addAttribute("getAllTrip", tripService.fecthOnFilter(email, object,
        UpdatePageableUntility.updatePageable(pageable, 10)));
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

}
