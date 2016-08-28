package com.practo.wp.security;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Component
public class SessionFilter implements Filter {
  private static List<String> secureUrls = new ArrayList<>();

  static {
    secureUrls.add("/weekend_planner/postpage/*");
  }

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
      throws IOException, ServletException {
    if (arg0 instanceof HttpServletRequest) {
      String uri = ((HttpServletRequest) arg0).getRequestURI();
      for (String secureUri : secureUrls) {
        if (uri.startsWith(secureUri)) {
          ((HttpServletResponse) arg1).sendRedirect("/weekend_planner");
        } else {
          chain.doFilter(arg0, arg1);
        }

      }
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    System.out.println("Chain called 2");

  }

}
