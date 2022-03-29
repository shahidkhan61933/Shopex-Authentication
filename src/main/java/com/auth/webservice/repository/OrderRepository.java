package com.auth.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auth.webservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query(value = "select * from eshopee_orders s where s.ordername like %:ordername%",nativeQuery = true)
	List<Order>findByName(String ordername);
	
	
	

}
