package com.Geekster.Portal.Services;

import com.Geekster.Portal.Models.Laptop;
import com.Geekster.Portal.Models.Student;
import com.Geekster.Portal.Repositories.ILaptopRepository;
import com.Geekster.Portal.Repositories.IStudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    private ILaptopRepository laptopRepository;
    @Autowired
    private IStudentRepository studentRepository;

    public Laptop createLaptop(Laptop laptop) {
        String studentId = laptop.getStudent().getStudentId();
        Optional<Student> optionalStudent= studentRepository.findById(studentId);
        if(optionalStudent.isPresent()){
            laptop.setStudent( optionalStudent.get());
        }else{
            throw new EntityNotFoundException("Student with id : " + studentId + " not found");
        }
        return laptopRepository.save(laptop);
    }

    public Optional<Laptop> getLaptopById(String id) {
        boolean isLaptopPresent = laptopRepository.existsById(id);
        if(isLaptopPresent){
            return laptopRepository.findById(id);
        }
        return Optional.empty();
    }

    public Laptop updateLaptop(String id, Laptop updateLaptop) {
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if(optionalLaptop.isPresent()){
            Laptop laptop = optionalLaptop.get();
            laptop.setLaptopId(updateLaptop.getLaptopId());
            laptop.setName(updateLaptop.getName());
            laptop.setBrand(updateLaptop.getBrand());
            laptop.setStudent(updateLaptop.getStudent());
            laptop.setPrice(updateLaptop.getPrice());
            return laptopRepository.save(laptop);
        }else{
            throw new EntityNotFoundException("Laptop with id : "+id+" not found");
        }
    }

    public ResponseEntity<String> deleteLaptopById(String id) {
        boolean isLaptopPresent = laptopRepository.existsById(id);
        if(isLaptopPresent){
            laptopRepository.deleteById(id);
            return new ResponseEntity<>("Laptop deleted successfully..Thank you!!",
                    HttpStatus.NO_CONTENT);
        }else{
            throw new EntityNotFoundException("Laptop with id : "+id+" not found");
        }
    }
}
