package com.ruby.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@Configuration
public class ApiEndpointConfiguration implements WebMvcRegistrations {

  private final ApiProperties apiProperties;

  @Autowired
  public ApiEndpointConfiguration(final ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
  }

  @Override
  public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
    final String apiPrefix = apiProperties.getApiPrefix();

    return new RequestMappingHandlerMapping() {

      @Override
      protected void registerHandlerMethod(final Object handler, final Method method,
                                           final RequestMappingInfo mapping) {
        final Class<?> beanType = method.getDeclaringClass();
        RequestMappingInfo modifiedMapping = mapping;
        if (AnnotationUtils.findAnnotation(beanType, RestController.class) != null) {
          final PatternsRequestCondition apiPattern =
              new PatternsRequestCondition(apiPrefix).combine(mapping.getPatternsCondition());

          modifiedMapping = new RequestMappingInfo(mapping.getName(), apiPattern,
              mapping.getMethodsCondition(), mapping.getParamsCondition(),
              mapping.getHeadersCondition(), mapping.getConsumesCondition(),
              mapping.getProducesCondition(), mapping.getCustomCondition());
        }

        super.registerHandlerMethod(handler, method, modifiedMapping);
      }
    };
  }

}
