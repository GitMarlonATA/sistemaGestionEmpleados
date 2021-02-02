package com.sistemaGestionEmpleados.adapters.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sistemaGestionEmpleados.application.domain.Empleado;
import com.sistemaGestionEmpleados.application.domain.EmpleadoPK;
import com.sistemaGestionEmpleados.application.port.outgoing.ActualizarEmpleadoPort;
import com.sistemaGestionEmpleados.application.port.outgoing.GuardarEmpleadoPort;
import com.sistemaGestionEmpleados.application.port.outgoing.ObtenerEmpleadoPort;
import com.sistemaGestionEmpleados.application.port.outgoing.ObtenerEmpleadosPort;

@Component
public class EmpleadoRepository implements ObtenerEmpleadoPort,ObtenerEmpleadosPort, GuardarEmpleadoPort, ActualizarEmpleadoPort{

	private SpringDataEmpleadoRepository repository;
	
	public EmpleadoRepository(SpringDataEmpleadoRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void guardarEmpleado(Empleado empleado) {
		repository.save(empleado);
	}

	@Override
	public List<Empleado> obtenerEmpleados() {
		return repository.findAll();
	}

	@Override
	public Empleado obtenerEmpleado(String tipoidentificacion, String numeroidentificacion) {
		try {
			return repository.findById(new EmpleadoPK(tipoidentificacion,numeroidentificacion)).get();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public int findByEmail(String email)
	{
		List<String> res = repository.findByEmail(email);
		return res.size();
	}

	@Override
	public boolean actualizarEmpleado(Empleado empleado) {
		repository.saveAndFlush(empleado);
		return true;
	}

}
