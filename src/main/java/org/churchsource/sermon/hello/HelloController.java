package org.churchsource.sermon.hello;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  
  @PersistenceContext
  private EntityManager entityManager;
  
  @RequestMapping("/")
  public String index() {
      return "Greetings from Spring!";
  }
}
