package com.hamitmizrak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//spring security dahil etmemek
@SpringBootApplication
(exclude =
{
  org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
  org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
public class SpringBootDockerPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerPostgresqlApplication.class, args);
    }

}
