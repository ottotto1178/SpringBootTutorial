package com.tutorial.tutorial.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanDefine {
  // TODO 後でコメントを外す
  // @Bean
  // PasswordEncoder passwordEncoder() {
  //   return new BCryptPasswordEncoder();
  // }

  @Bean
  Mapper mapper() {
    return new DozerBeanMapper();
  }
}
