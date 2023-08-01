package com.amazon.shoppin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.shoppin.dto.Users;
import com.amazon.shoppin.entity.Orders;
import com.amazon.shoppin.entity.User;
import com.amazon.shoppin.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {

		return userService.saveUser(user);

	}

	@GetMapping("/getorderbyid")
	public List<Orders> getOrdersById(@RequestParam("id") Integer id) {

		return userService.getOrdersById(id);

	}

	@GetMapping("/allusers")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/allorders")
	public List<Orders> getAllOrders() {

		return userService.getOrders();
	}

	@GetMapping("/orderbyorderid/{id}")
	public Orders getOrderByOrderId(@PathVariable("id") int id) {

		return userService.getOrdersByOrderId(id);

	}

	
	@PutMapping("/update")
	public User updateUser(@RequestBody User u) {

		return userService.updateUser(u);

	}

	@DeleteMapping("/delete/{id}")
	public User deleteUser(@PathVariable("id") Integer id) {

		System.out.println(id);
		return userService.deleteUser(id);

	}

}
