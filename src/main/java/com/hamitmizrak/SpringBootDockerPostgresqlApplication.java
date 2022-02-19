package com.hamitmizrak;

import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class SpringBootDockerPostgresqlApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerPostgresqlApplication.class, args);
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO product (product_name, product_trade) VALUES ("
                + "'Ürün adı', 'bilgisayar')";

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
    }

}
