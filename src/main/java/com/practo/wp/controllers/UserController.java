package com.practo.wp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.wp.model.User;
import com.practo.wp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService service;

  // // @RequestMapping(method = RequestMethod.GET)
  // public UserEntity get() {
  // System.out.println("came -here");
  // return dao.findOne("ankitsin37@gmail.com");
  // }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User get(@PathVariable("id") Integer id) {
    System.out.println(id);
    User dto = service.get(id);
    return dto;
    // Iterable<UserEntity> temp = dao.findByMobile(id);
    // return temp;
    // System.out.println("came -here");
    // return dao.findOne("ankitsin37@gmail.com");
  }

}
