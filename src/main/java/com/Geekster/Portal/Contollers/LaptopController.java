package com.Geekster.Portal.Contollers;

import com.Geekster.Portal.Models.Laptop;
import com.Geekster.Portal.Services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @PostMapping
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return laptopService.createLaptop(laptop);
    }
    @GetMapping("/{id}")
    public Optional<Laptop> getLaptopById(@PathVariable String id) {
        return laptopService.getLaptopById(id);
    }

    @PutMapping("/{id}")
    public Laptop updateLaptop(@PathVariable String id ,@RequestBody Laptop updateLaptop) {
        return laptopService.updateLaptop(id, updateLaptop);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLaptopById(@PathVariable String id) {
        return laptopService.deleteLaptopById(id);
    }
}
