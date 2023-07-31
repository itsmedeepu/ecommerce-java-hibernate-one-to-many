package com.amazon.shoppin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.shoppin.dto.Users;
import com.amazon.shoppin.entity.Orders;
import com.amazon.shoppin.entity.User;
import com.amazon.shoppin.repository.OrdersReposiotry;
import com.amazon.shoppin.repository.Userrepository;

import jakarta.persistence.criteria.Order;

@Service
public class UserService {

	@Autowired
	Userrepository userrepository;

	@Autowired
	OrdersReposiotry ordersReposiotry;

	public User saveUser(User user) {

		return userrepository.save(user);

	}

	public List<Orders> getOrdersById(int id) {
		return ordersReposiotry.getOrdersByUserId(id);

	}

	public List<Users> getAllUsers() {

		return userrepository.getAllUser();
	}

	public List<Orders> getOrders() {

		return ordersReposiotry.findAll();
	}

	public Orders getOrdersByOrderId(int id) {

		Optional<Orders> findById = ordersReposiotry.findById(id);
		Orders orders = findById.get();
		return orders;
	}

}
