package com.Geekster.Portal.Services;

import com.Geekster.Portal.Models.Course;
import com.Geekster.Portal.Models.Laptop;
import com.Geekster.Portal.Repositories.IBookRepository;
import com.Geekster.Portal.Repositories.ICourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private ICourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(String id, Course updateCourse) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isPresent()){
            Course course = optionalCourse.get();
            course.setCourseId(updateCourse.getCourseId());
            course.setDuration(updateCourse.getDuration());
            course.setDescription(updateCourse.getDescription());
            course.setTitle(updateCourse.getTitle());
            course.setStudentList(updateCourse.getStudentList());
            return courseRepository.save(course);
        }else{
            throw new EntityNotFoundException("Course with id : "+id+" not found");
        }

    }

    public ResponseEntity<String> deleteCourseById(String id) {
        boolean isCoursePresent = courseRepository.existsById(id);
        if(isCoursePresent){
            courseRepository.deleteById(id);
            return new ResponseEntity<>("Course deleted successfully..Thank you!!",
                    HttpStatus.NO_CONTENT);
        }else{
            throw new EntityNotFoundException("Course with id : "+id+" not found");
        }
    }
}
