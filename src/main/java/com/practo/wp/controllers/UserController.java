package com.practo.wp.controllers;

import com.practo.wp.model.User;
import com.practo.wp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User get(@PathVariable("id") Integer id) {
    User dto = service.get(id);
    return dto;
  }

}
