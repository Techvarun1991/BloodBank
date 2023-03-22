package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.entity.Requests;

@Repository
public interface RequestRepository extends JpaRepository<Requests, Integer>{
	
	@Query("select r from Requests r where r.status=null")
	List<Requests> findByStatus(); 
	
//	@Query("select r from Requests r where r.user_id= :#{#requests.user_id}")
//	List<Requests> findByUserId(@Param(value = "user_id")int user_id); 


}
