package com.rafael.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rafael.crud.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    
}
