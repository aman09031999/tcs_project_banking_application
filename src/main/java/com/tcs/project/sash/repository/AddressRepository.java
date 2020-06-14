package com.tcs.project.sash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tcs.project.sash.model.Address;

@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<Address, String> {

}
