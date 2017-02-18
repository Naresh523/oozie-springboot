package com.bigadataguide;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by cloudera on 2/17/17.
 */
@SuppressWarnings("CanBeFinal")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RestApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
    public static ApplicationContext globalApplicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RestApplication.globalApplicationContext = applicationContext;

    }
}
