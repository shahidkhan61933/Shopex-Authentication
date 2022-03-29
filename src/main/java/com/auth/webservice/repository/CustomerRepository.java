package com.auth.webservice.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auth.webservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value = "select * from eshopee_customers s where s.name like %:name%",nativeQuery = true)
	List<Customer>findByName(String name);
	
	@Query(value = "select * from eshopee_customers s where s.email like %:email%",nativeQuery = true)
	List<Customer>findByEmail(String email);
	

}
