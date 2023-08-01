package com.amazon.shoppin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		List<Users> users = userrepository.getAllUser();

		List<Users> collect = users.stream().sorted((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()))
				.collect(Collectors.toList());
		return collect;
	}

	public List<Orders> getOrders() {
		return ordersReposiotry.findAll();
	}

	public Orders getOrdersByOrderId(int id) {

		Optional<Orders> findById = ordersReposiotry.findById(id);
		Orders orders = findById.get();
		return orders;
	}

	public User updateUser(User u) {

		return userrepository.save(u);
	}

	public User deleteUser(int id) {

		try {

			Optional<User> findById = userrepository.findById(id);

			User user = findById.get();

			userrepository.deleteById(id);

			return user;

		} catch (Exception e) {
			System.out.println("user not with this id  ");
		}

		return null;

	}

}
