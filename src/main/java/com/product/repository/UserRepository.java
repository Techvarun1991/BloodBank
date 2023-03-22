package com.product.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.product.entity.User;

import antlr.collections.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public boolean existsByEmail(String email);
	public User findById(int id);
	public User findByEmail(String email);

}
