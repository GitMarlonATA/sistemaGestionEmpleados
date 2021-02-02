package com.sistemaGestionEmpleados.application.port.outgoing;

import com.sistemaGestionEmpleados.application.domain.Empleado;

public interface ObtenerEmpleadoPort {
	Empleado obtenerEmpleado(String tipoidentificacion, String numeroidentificacion);
}
