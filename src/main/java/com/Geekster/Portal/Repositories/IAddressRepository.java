package com.Geekster.Portal.Repositories;

import com.Geekster.Portal.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository  extends JpaRepository<Address, String> {
}
