package com.practo.wp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/redirect")
public class RedirectController {
  @RequestMapping(value = "", method = RequestMethod.GET)
  public String method(HttpServletResponse httpServletResponse) {
    return "redirect:http://docs.weekendplanner.apiary.io/";
  }

}
