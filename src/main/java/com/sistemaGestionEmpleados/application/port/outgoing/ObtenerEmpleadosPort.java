package com.sistemaGestionEmpleados.application.port.outgoing;

import java.util.List;

import com.sistemaGestionEmpleados.application.domain.Empleado;

public interface ObtenerEmpleadosPort {
	List<Empleado> obtenerEmpleados();

}
