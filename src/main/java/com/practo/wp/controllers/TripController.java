package com.practo.wp.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

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

import com.practo.wp.model.Trip;
import com.practo.wp.model.TripFilter;
import com.practo.wp.service.TripService;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/trip")
public class TripController {
  @Autowired
  private TripService service;

  @RequestMapping(value = "all",method = RequestMethod.GET)
  public Iterable<Trip> get(Pageable pageable) {
    // System.out.println(id);
    Iterable<Trip> dto = service.fetchAll(updatePageable(pageable, 50));
    return dto;
    // Iterable<UserEntity> temp = dao.findByMobile(id);
    // return temp;
    // System.out.println("came -here");
    // return dao.findOne("ankitsin37@gmail.com");
  }

  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public Trip get2(@PathVariable("id") int id) {
    // System.out.println(id);
    Trip dto = service.fetchOne(id);
    return dto;
    // Iterable<UserEntity> temp = dao.findByMobile(id);
    // return temp;
    // System.out.println("came -here");
    // return dao.findOne("ankitsin37@gmail.com");
  }
  
  
  @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
  public Iterable<Trip> get1(@PathVariable("id") int id) {
    System.out.println(id);
    Iterable<Trip> dto = service.fetchUserData(id);
    return dto;
    // Iterable<UserEntity> temp = dao.findByMobile(id);
    // return temp;
    // System.out.println("came -here");
    // return dao.findOne("ankitsin37@gmail.com");
  }

//  @RequestMapping(value = "/filter/{filter}", method = RequestMethod.GET)
//  public Iterable<Trip> getTripWithFilter(@PathVariable("filter") String filter) {
//    String[] splitted=filter.split(" ");
//    System.out.println(Arrays.toString(splitted));
//    for(String temp:splitted)
//    {
//      String[] key_value=temp.split("=");
//      String key=key_value[0];
//      String values= key_value[1];
//      System.out.println(key);
//      System.out.println(values);
//    }
//    return null;
//  }

   @RequestMapping(value = "/filter", method = RequestMethod.GET)
   public Iterable<Trip> get2(TripFilter filter,Pageable pageable) {
   System.out.println(filter);
   Iterable<Trip> dto = service.fecthOnFilter(filter,pageable);
   return dto;
   }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Trip> create(@RequestBody Trip d) {
//    System.out.println(d.PostedUserId());
    Trip dto = service.create(d);
    ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<Trip> update(@RequestBody Trip d) {
    Trip dto = service.update(d);
    
    ResponseEntity<Trip> re = new ResponseEntity<Trip>(dto, HttpStatus.OK);
    return re;
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

  public static Pageable updatePageable(final Pageable source, final int size)
  {
      return new PageRequest(source.getPageNumber(), size, source.getSort());
  }
}
