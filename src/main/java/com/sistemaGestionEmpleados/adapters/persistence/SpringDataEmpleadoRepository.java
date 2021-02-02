package com.sistemaGestionEmpleados.adapters.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemaGestionEmpleados.application.domain.Empleado;
import com.sistemaGestionEmpleados.application.domain.EmpleadoPK;

public interface SpringDataEmpleadoRepository extends JpaRepository<Empleado, EmpleadoPK>{
	@Query("SELECT e.primernombre FROM Empleado as e WHERE email LIKE :email%")
    public List<String> findByEmail(@Param("email") String email);
}
