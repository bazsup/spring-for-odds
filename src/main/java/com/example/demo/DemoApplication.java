package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public CommandLineRunner init(EmployeeRepository employeeRepository) {
        return (args -> {
            employeeRepository.save(new Employee("john", "doe"));
            employeeRepository.save(new Employee("sammy", "doe"));
            employeeRepository.save(new Employee("james", "doe"));
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
