package pl.uwm.banasiuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "pl.uwm.banasiuk" })
public class CalculatorSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorSpringBoot.class, args);
    }
}
