package com.ageless;


import com.ageless.config.Mapper.DataSourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
public class AgelessApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgelessApplication.class, args);
    }
}
