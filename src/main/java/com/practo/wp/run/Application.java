package com.practo.wp.run;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@ImportResource("classpath:hibernate.xml")
@ComponentScan(basePackages = {"com.practo.wp"})
@EntityScan("com.practo.wp.data.entity")
@EnableJpaRepositories("com.practo.wp.data.dao")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  // @RequestMapping(value = "/", method = RequestMethod.GET)
  // public String method(HttpServletResponse httpServletResponse) {
  // return "redirect:" + "http://http://docs.accommodationfinder.apiary.io/";
  // }
}
