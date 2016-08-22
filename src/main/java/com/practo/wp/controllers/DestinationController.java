package com.practo.wp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.wp.model.Destination;
import com.practo.wp.service.DestinationService;


@RestController
@RequestMapping("/destination")
public class DestinationController {

  @Autowired
  private DestinationService DestinationService;

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public Iterable<Destination> get() {
    // System.out.println(id);
    Iterable<Destination> dto = DestinationService.getall();
    return dto;
    // Iterable<UserEntity> temp = dao.findByMobile(id);
    // return temp;
    // System.out.println("came -here");
    // return dao.findOne("ankitsin37@gmail.com");
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Destination get(@PathVariable("id") Integer id) {
    System.out.println(id);
    Destination dto = DestinationService.getById(id);
    return dto;
    // Iterable<UserEntity> temp = dao.findByMobile(id);
    // return temp;
    // System.out.println("came -here");
    // return dao.findOne("ankitsin37@gmail.com");
  }
}
