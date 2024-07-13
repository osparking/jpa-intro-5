package space.bum.sboot.config;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManager;

@Configuration
public class ApplConfig {

  @Autowired
  private EntityManager entityManager;

  @Bean
  Session getSession() {
    return entityManager.unwrap(Session.class);
  }
}