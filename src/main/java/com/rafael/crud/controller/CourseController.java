package com.rafael.crud.controller;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.crud.model.Course;
import com.rafael.crud.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {


    private final CourseRepository repo;

    
    @GetMapping //Associar com o DoGet do servlet
    public List<Course> list(){
        return repo.findAll();
    }

    
}
