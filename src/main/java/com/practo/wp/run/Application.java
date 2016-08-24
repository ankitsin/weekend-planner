package com.practo.wp.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@ImportResource("classpath:hibernate.xml")
@ComponentScan(basePackages = {"com.practo.wp"})
@EntityScan("com.practo.wp.data.entity")
@EnableJpaRepositories("com.practo.wp.data.dao")
@Controller
public class Application extends SpringBootServletInitializer {


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
