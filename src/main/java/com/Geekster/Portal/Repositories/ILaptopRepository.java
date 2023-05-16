package com.Geekster.Portal.Repositories;

import com.Geekster.Portal.Models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopRepository extends JpaRepository<Laptop, String> {
}
