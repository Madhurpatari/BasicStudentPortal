package com.Geekster.Portal.Contollers;

import com.Geekster.Portal.Models.Course;
import com.Geekster.Portal.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable String id,@RequestBody Course updateCourse) {
        return courseService.updateCourse(id,updateCourse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable String id) {
        return courseService.deleteCourseById(id);
    }
}
