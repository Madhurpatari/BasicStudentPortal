package com.Geekster.Portal.Services;

import com.Geekster.Portal.Models.Student;
import com.Geekster.Portal.Repositories.IStudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private IStudentRepository studentRepository;

    public ResponseEntity<Student> createStudent(Student student) {
        return new ResponseEntity<>(studentRepository.save(student),HttpStatus.OK);
    }

    public Optional<Student> getStudentById(String id) {
        boolean isPresent = studentRepository.existsById(id);
        if(isPresent){
            return studentRepository.findById(id);
        }else{
            throw new IllegalStateException("Student with id : "+id+" not found");
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(String id,Student updateStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            student.setStudentId(updateStudent.getStudentId());
            student.setAddress(updateStudent.getAddress());
            student.setAge(updateStudent.getAge());
            student.setBranch(updateStudent.getBranch());
            student.setDepartment(updateStudent.getDepartment());
            student.setName(updateStudent.getName());
            student.setPhoneNumber(updateStudent.getPhoneNumber());
            return studentRepository.save(student);
        }else{
            throw new EntityNotFoundException("Student with id : "+id+" not found");
        }
    }

    public ResponseEntity<String> deleteStudentById(String id) {
        boolean isStudentPresent = studentRepository.existsById(id);
        if(isStudentPresent){
            studentRepository.deleteById(id);
            return new ResponseEntity<>("Student details deleted successfully..Thank you!!",
                    HttpStatus.NO_CONTENT);
        }else{
            throw new EntityNotFoundException("Student with id : "+id+" not found");
        }
    }
}
