package com.amazon.shoppin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazon.shoppin.dto.Users;
import com.amazon.shoppin.entity.User;

@Repository
public interface Userrepository extends JpaRepository<User, Integer> {
	
	
	@Query("select new com.amazon.shoppin.dto.Users(u.id,u.name,u.email) from User u")
	List<Users> getAllUser();

}
