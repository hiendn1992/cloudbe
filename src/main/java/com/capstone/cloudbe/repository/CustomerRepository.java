package com.capstone.cloudbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.cloudbe.Domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
