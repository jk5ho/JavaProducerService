package com.ruby.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private ApiProperties apiProperties;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin();
  }

  @Override
  public void configure(final WebSecurity web) throws Exception {
    final Collection<String> ignored = apiProperties.getIgnored();
    web.ignoring().antMatchers(ignored.toArray(new String[ignored.size()]));
  }
}
