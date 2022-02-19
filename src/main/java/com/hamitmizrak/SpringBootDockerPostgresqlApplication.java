package com.hamitmizrak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;

//spring security dahil etmemek
@SpringBootApplication(exclude =
{
  org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
  org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)

//Audit aktif etmek icin auditorAware ==> Bean adı
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringBootDockerPostgresqlApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerPostgresqlApplication.class, args);
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

    }

//    @Override
//    public void run(String... args) throws Exception {
//        String sql = "INSERT INTO students (name, email) VALUES ("
//                + "'Nam Ha Minh', 'nam@codejava.net')";
//
//        int rows = jdbcTemplate.update(sql);
//        if (rows > 0) {
//            System.out.println("A new row has been inserted.");
//        }
//    }

}
