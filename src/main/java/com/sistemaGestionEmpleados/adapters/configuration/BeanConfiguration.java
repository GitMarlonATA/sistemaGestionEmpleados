package com.sistemaGestionEmpleados.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sistemaGestionEmpleados.SistemaGestionEmpleadosApplication;
import com.sistemaGestionEmpleados.adapters.persistence.EmpleadoRepository;
import com.sistemaGestionEmpleados.application.services.EmpleadoService;

@Configuration
@ComponentScan(basePackageClasses = SistemaGestionEmpleadosApplication.class)
public class BeanConfiguration {
	
	@Bean
	EmpleadoService empleadoService(EmpleadoRepository empleadoRepository) {
		return new EmpleadoService(empleadoRepository, empleadoRepository, empleadoRepository, empleadoRepository);
	}

}
