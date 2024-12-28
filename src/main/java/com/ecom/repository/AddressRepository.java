package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
