package com.rafael.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.crud.model.Course;
import com.rafael.crud.repository.CourseRepository;

@RestController
@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
    CommandLineRunner initDatabase( CourseRepository repo){
        return args ->  {

            repo.deleteAll();

            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory("Front-End");
            
            repo.save(c);
        };
    }
}
