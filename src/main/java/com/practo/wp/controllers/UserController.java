package com.practo.wp.controllers;

import com.practo.wp.exception.ExceptionMessageThrow;
import com.practo.wp.model.User;
import com.practo.wp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService service;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String method(HttpServletResponse httpServletResponse) {
    return "redirect:" + "http://http://docs.accommodationfinder.apiary.io/";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User get(@PathVariable("id") Integer id) throws MessagingException {
    User dto = service.get(id);
    return dto;
  }

}
