package com.apbdoo.lab2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.apbdoo.lab2")
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class SubscriptionConfig {
}
