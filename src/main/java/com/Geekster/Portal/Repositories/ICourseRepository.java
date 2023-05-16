package com.Geekster.Portal.Repositories;

import com.Geekster.Portal.Models.Course;
import com.Geekster.Portal.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,String> {
}
