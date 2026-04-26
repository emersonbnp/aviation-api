package com.aviation.api.application;

import com.aviation.api.application.provider.navigationaldata.NavigationalDataProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan("com.aviation.api.*")
@EnableConfigurationProperties(NavigationalDataProperties.class)
@SpringBootApplication
public class AviationApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(AviationApiApplication.class, args);
  }
}
