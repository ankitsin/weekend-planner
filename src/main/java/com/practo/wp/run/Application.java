package com.practo.wp.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan(basePackages = {"com.practo.wp"})
@EntityScan("com.practo.wp.data.entity")
@EnableJpaRepositories("com.practo.wp.data.dao")
@Controller
public class Application {
  

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
