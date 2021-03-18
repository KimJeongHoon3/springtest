package me.test.springcoretest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"file:config/test.properties","file:config/test2.properties"})
public class SpringcoretestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoretestApplication.class, args);
    }

}
