package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Appointments;

public interface AppointmentRepository extends JpaRepository<Appointments, Integer>{

}
