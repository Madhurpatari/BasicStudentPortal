package com.Geekster.Portal.Repositories;

import com.Geekster.Portal.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,String> {
}
