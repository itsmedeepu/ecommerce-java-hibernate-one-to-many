package com.amazon.shoppin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amazon.shoppin.entity.Orders;

@Repository
public interface OrdersReposiotry extends JpaRepository<Orders, Integer> {

	@Query("SELECT t FROM User u JOIN u.orders t WHERE u.id = :userId")
	List<Orders> getOrdersByUserId(@Param("userId") Integer userId);

	
}