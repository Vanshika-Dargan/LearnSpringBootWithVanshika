package com.vanshika.wrap.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Data
@ConfigurationProperties(prefix="wrap")
public class WrapConfig {
    String bread;
    String cheese;
    String toppings;
}
