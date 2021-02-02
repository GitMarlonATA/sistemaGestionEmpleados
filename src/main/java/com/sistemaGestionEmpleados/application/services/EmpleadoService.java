package com.sistemaGestionEmpleados.application.services;

import java.util.List;

import com.sistemaGestionEmpleados.application.domain.Empleado;
import com.sistemaGestionEmpleados.application.port.incoming.ActualizarEmpleadoUseCase;
import com.sistemaGestionEmpleados.application.port.incoming.AgregarEmpleadoUseCase;
import com.sistemaGestionEmpleados.application.port.incoming.ListarUseCase;
import com.sistemaGestionEmpleados.application.port.incoming.ObtenerEmpleadoUseCase;
import com.sistemaGestionEmpleados.application.port.outgoing.ActualizarEmpleadoPort;
import com.sistemaGestionEmpleados.application.port.outgoing.GuardarEmpleadoPort;
import com.sistemaGestionEmpleados.application.port.outgoing.ObtenerEmpleadoPort;
import com.sistemaGestionEmpleados.application.port.outgoing.ObtenerEmpleadosPort;

public class EmpleadoService implements ObtenerEmpleadoUseCase, ListarUseCase, AgregarEmpleadoUseCase, ActualizarEmpleadoUseCase{
	
	private ObtenerEmpleadosPort obtenerEmpleadosPort;
	private ObtenerEmpleadoPort obtenerEmpleadoPort;
	private GuardarEmpleadoPort guardarEmpleadoPort;
	private ActualizarEmpleadoPort actualizarEmpleadoPort;

	public EmpleadoService() {
		super();
	}

	public EmpleadoService(ObtenerEmpleadosPort obtenerEmpleadosPort, ObtenerEmpleadoPort obtenerEmpleadoPort,
			GuardarEmpleadoPort guardarEmpleadoPort, ActualizarEmpleadoPort actualizarEmpleadoPort) {
		super();
		this.obtenerEmpleadosPort = obtenerEmpleadosPort;
		this.obtenerEmpleadoPort = obtenerEmpleadoPort;
		this.guardarEmpleadoPort = guardarEmpleadoPort;
		this.actualizarEmpleadoPort = actualizarEmpleadoPort;
	}

	@Override
	public boolean agregarEmpleado(Empleado empleado) {
		try {
			String email = empleado.getEmail();
			String emailSplit[] = email.split("@");
			String nickEmail = emailSplit[0];
			int cont = guardarEmpleadoPort.findByEmail(nickEmail);
			if(cont!=0)
			{
				empleado.setEmail(nickEmail+"."+cont+"@"+emailSplit[1]);
			}

			guardarEmpleadoPort.guardarEmpleado(empleado);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Empleado> listar() {
		return obtenerEmpleadosPort.obtenerEmpleados();
	}

	@Override
	public Empleado obtenerEmpleado(String tipoidentificacion, String numeroidentificacion) {
		return obtenerEmpleadoPort.obtenerEmpleado(tipoidentificacion, numeroidentificacion);
	}

	@Override
	public boolean actualizarEmpleado(Empleado empleado) {
		return actualizarEmpleadoPort.actualizarEmpleado(empleado);
	}
	

}
