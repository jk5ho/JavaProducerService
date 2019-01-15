package com.ruby.util.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

@Data
@Component
@ConfigurationProperties(prefix = "api")
@Validated
public class ApiProperties {

  private String basePath;

  private Collection<String> ignored;

  public String getApiPrefix() {
    return String.format("/%s", basePath);
  }

}
